package vistas;

import java.io.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class FXMLRecuperacionController {

    @FXML
    private TextField txtEmailRecuperacion;

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void btnRecuperacion(ActionEvent event) {
        final String HOST = "localhost";
        final String TLS_PORT = "25";
        final String SENDER_USERNAME = "TiendaJuegos@elorrieta.com";
        final String SENDER_PASSWORD = ""; // Aquí la contraseña debería ser la correspondiente si es necesario

        // Generar un código aleatorio de 8 dígitos
        String codigo = generarCodigoAleatorio();

        // Modificar el archivo "codigo.txt" en el escritorio con el código generado
        modificarArchivoCodigo(codigo);

        // Configuración de propiedades para la sesión de correo
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", HOST);
        props.setProperty("mail.smtp.port", TLS_PORT);
        props.setProperty("mail.smtp.starttls.enable", "false");
        props.setProperty("mail.smtps.auth", "false");

        Session session = Session.getInstance(props, null); // null porque no hay autenticación

        Transport transport = null;
        try {
            String email = txtEmailRecuperacion.getText();
            // Crear el mensaje
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(SENDER_USERNAME));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
            msg.setSubject("Código de recuperación");
            msg.setSentDate(new Date());
            msg.setText("Aquí está su código de recuperación: " + codigo, "utf-8", "html");

            // Enviar el mensaje
            transport = session.getTransport("smtp");
            transport.connect(HOST, SENDER_USERNAME, SENDER_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Correo enviado con éxito.");

            // Redirigir a la ventana FXMLCambioContra si todo ha salido bien
            redirigirAFXMLCambioContra();

        } catch (MessagingException e) {
            Logger.getLogger(FXMLRecuperacionController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (transport != null) {
                    transport.close();
                }
            } catch (MessagingException e) {
                Logger.getLogger(FXMLRecuperacionController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    private String generarCodigoAleatorio() {
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            codigo.append(random.nextInt(10));  // Añade un número aleatorio entre 0 y 9
        }
        return codigo.toString();
    }

    private void modificarArchivoCodigo(String codigo) {
        // Ruta para guardar el archivo "codigo.txt" en el escritorio
        final String RUTA_ARCHIVO = "archivos/codigo.txt"; 

        // Escribir el nuevo código en el archivo "codigo.txt"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
            writer.write(codigo);  // Escribir solo el código en el archivo
            System.out.println("Código actualizado en el archivo en el escritorio.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    private void redirigirAFXMLCambioContra() {
        if (mainApp != null) {
            try {
                // Redirigir a la ventana FXMLCambioContra
                mainApp.mostrarCambioContra(); // Asegúrate de tener este método en Main.java
            } catch (Exception ex) {
                Logger.getLogger(FXMLRecuperacionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void volverInicioSesion(ActionEvent event) {
        // Crear una alerta de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar salida");
        alert.setHeaderText(null);
        alert.setContentText("¿Deseas volver a la ventana de inicio de sesión?");

        // Mostrar la alerta y esperar la respuesta del usuario
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Si el usuario confirma, mostrar la ventana de inicio de sesión
            if (mainApp != null) {
                try {
                    mainApp.mostrarLogin();
                } catch (Exception ex) {
                    Logger.getLogger(FXMLRecuperacionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            event.consume();  // Cancelar la acción si el usuario no confirma
        }
    }
}
