package vistas;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLTiendasController {

    @FXML
    private VBox itemContainer; // Este es el VBox que se llenará con los items de las tiendas

    private Main mainApp; // Instancia de la clase principal

    // Este método se llama automáticamente cuando se carga el archivo FXML
    @FXML
    public void initialize() {
        // Verificación de que itemContainer está correctamente inicializado
        if (itemContainer == null) {
            System.out.println("Error: itemContainer no está inicializado.");
        }
        // Llamamos al método para llenar el contenedor de tiendas con datos desde el archivo
        fillStoresFromFile();
    }

    // Este método lee los datos de tiendas desde el archivo 'tiendas.txt'
    private void fillStoresFromFile() {
        // Ruta del archivo
        String filePath = "archivos/tiendas.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            String title = "", description = "", imagePath = "";

            // Leemos el archivo línea por línea
            while ((line = reader.readLine()) != null) {
                // Si la línea contiene un Titulo, lo extraemos
                if (line.startsWith("Titulo: ")) {
                    title = line.substring("Titulo: ".length()).trim();
                }
                // Si la línea contiene una Descripcion, la extraemos
                else if (line.startsWith("Descripcion: ")) {
                    description = line.substring("Descripcion: ".length()).trim();
                }
                // Si la línea contiene una Foto, la extraemos
                else if (line.startsWith("Foto: ")) {
                    imagePath = line.substring("Foto: ".length()).trim();
                }

                // Cuando tenemos todos los datos, los agregamos a la lista de tiendas
                if (!title.isEmpty() && !description.isEmpty() && !imagePath.isEmpty()) {
                    addItem(title, description, imagePath); // Llamamos al método para agregar la tienda
                    title = description = imagePath = ""; // Limpiamos las variables para la siguiente tienda
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Este método agrega un nuevo item al VBox (una tienda)
    @FXML
    private void addItem(String titulo, String descripcion, String imagen) {
        // Verificamos si itemContainer está correctamente inicializado
        if (itemContainer == null) {
            System.out.println("Error: itemContainer no está inicializado.");
            return; // Evitamos hacer nada si itemContainer es nulo
        }

        // Creamos un nuevo HBox para contener la imagen y el texto
        HBox itemBox = new HBox();
        itemBox.setSpacing(10); // Establecemos el espacio entre los elementos en el HBox

        // Creamos un ImageView con la imagen proporcionada (ruta a la imagen)
        ImageView imageView = new ImageView(new Image(imagen));
        imageView.setFitHeight(100);  // Ajustamos la altura de la imagen
        imageView.setFitWidth(100);   // Ajustamos el ancho de la imagen

        // Creamos un VBox para los textos de título y descripción
        VBox textBox = new VBox();
        Label titleLabel = new Label(titulo); // El título de la tienda
        titleLabel.setStyle("-fx-font-size: 14; -fx-text-fill: black;"); // Estilo para el título
        Label descriptionLabel = new Label(descripcion); // La descripción de la tienda
        descriptionLabel.setStyle("-fx-font-size: 12; -fx-text-fill: gray;"); // Estilo para la descripción
        descriptionLabel.setWrapText(true);  // Para que el texto se ajuste al tamaño del contenedor

        // Agregamos las etiquetas de título y descripción al VBox
        textBox.getChildren().addAll(titleLabel, descriptionLabel);

        // Agregamos la imagen y el VBox (con los textos) al HBox
        itemBox.getChildren().addAll(imageView, textBox);

        // Configuramos el manejador de eventos para el clic en el HBox
        itemBox.setOnMouseClicked(event -> {
            // Mostrar en consola la información del ítem (imagen, título y descripción)
            System.out.println("Título: " + titulo);
            System.out.println("Descripción: " + descripcion);
            System.out.println("Imagen: " + imagen);
            
            // Cargar la nueva ventana FXMLCompra.fxml
            try {
                mainApp.mostrarCompra();
            } catch (Exception ex) {
                Logger.getLogger(FXMLTiendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Finalmente, agregamos el HBox al VBox itemContainer para mostrarlo en la interfaz
        itemContainer.getChildren().add(itemBox);
        
        
    }

    // Método que permite configurar el MainApp, si necesitas acceder a él desde este controlador
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
}
