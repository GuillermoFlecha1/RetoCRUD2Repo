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

public class FXMLCambioContraController {

    @FXML
    private TextField txtCodigoRecuperacion;  // Campo de texto para ingresar el código de recuperación
    @FXML
    private TextField txtContraNueva;  // Campo de texto para la nueva contraseña
    @FXML
    private TextField txtContraRepetida;  // Campo de texto para confirmar la nueva contraseña

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void btnCambioContra(ActionEvent event) {
        String codigoIngresado = txtCodigoRecuperacion.getText();
        String nuevaContrasena = txtContraNueva.getText();
        String confirmarContrasena = txtContraRepetida.getText();

        // Verificar que las contraseñas coincidan
        if (!nuevaContrasena.equals(confirmarContrasena)) {
            mostrarAlerta("Error", "Las contraseñas no coinciden.");
            return;
        }

        // Verificar que el código de recuperación sea el mismo que el almacenado en "codigo.txt"
        if (!verificarCodigoRecuperacion(codigoIngresado)) {
            mostrarAlerta("Error", "El código de recuperación es incorrecto.");
            return;
        }

        // Si todo es correcto, actualizar la contraseña en "usuario.txt"
        actualizarContraseñaEnArchivo(nuevaContrasena);
    }

    private boolean verificarCodigoRecuperacion(String codigoIngresado) {
        final String RUTA_CODIGO = "archivos/codigo.txt"; // Ruta del archivo con el código de recuperación
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_CODIGO))) {
            String codigoGuardado = reader.readLine(); // Leemos el código almacenado
            return codigoGuardado != null && codigoGuardado.equals(codigoIngresado); // Comparamos el código ingresado con el guardado
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de código: " + e.getMessage());
            return false;
        }
    }

    private void actualizarContraseñaEnArchivo(String nuevaContrasena) {
        final String RUTA_ARCHIVO = "archivos/usuario.txt"; // Ruta del archivo con usuario y contraseña
        File archivo = new File(RUTA_ARCHIVO);
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Contraseña: ")) {
                    // Actualizamos la contraseña con la nueva
                    contenido.append("Contraseña: ").append(nuevaContrasena).append(System.lineSeparator());
                } else {
                    contenido.append(linea).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        // Escribir el contenido actualizado en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(contenido.toString());
            System.out.println("Contraseña actualizada en el archivo usuario.txt.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
        
        if (mainApp != null) {
                try {
                    mainApp.mostrarLogin();
                } catch (Exception ex) {
                    Logger.getLogger(FXMLCambioContraController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
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
                    Logger.getLogger(FXMLCambioContraController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            event.consume();  // Cancelar la acción si el usuario no confirma
        }
    }
}
