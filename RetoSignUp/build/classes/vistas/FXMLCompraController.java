package vistas;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class FXMLCompraController {

    private Main mainApp;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private TextField minPriceField; // Campo de texto para el precio mínimo

    @FXML
    private TextField maxPriceField; // Campo de texto para el precio máximo

    @FXML
    private Label priceRange;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private TextField dateField;

    @FXML
    private Button dateButton;

    @FXML
    private Button filterButton;

    // Método de inicialización
    public void initialize() {
        // Agregar géneros al ComboBox
        genreComboBox.getItems().addAll(
            "Acción", "Aventura", "Deportes", "Simulación", "Estrategia",
            "Peleas", "RPG", "Terror", "Carreras", "Multijugador"
        );

        // Configurar el evento de búsqueda
        searchButton.setOnMouseClicked(this::handleSearch);
        dateButton.setOnMouseClicked(this::handleDate);
        filterButton.setOnMouseClicked(this::handleFilter);
    }

    // Método para manejar el evento de búsqueda
    private void handleSearch(MouseEvent event) {
        String query = searchField.getText();
        System.out.println("Buscando: " + query);
    }

    // Método para manejar el evento de fecha (falta implementación para DatePicker)
    private void handleDate(MouseEvent event) {
        System.out.println("Lanzar DatePicker");
        // Implementar la lógica para abrir el DatePicker
    }

    // Método para manejar el evento de filtrado
    private void handleFilter(MouseEvent event) {
        // Obtener el valor del género seleccionado
        String genre = genreComboBox.getValue();
        
        // Obtener los valores de los campos de precio
        double minPrice = 0;
        double maxPrice = 0;

        try {
            // Convertir los campos de texto a números
            minPrice = Double.parseDouble(minPriceField.getText());
        } catch (NumberFormatException e) {
            System.out.println("El precio mínimo no es válido.");
        }

        try {
            maxPrice = Double.parseDouble(maxPriceField.getText());
        } catch (NumberFormatException e) {
            System.out.println("El precio máximo no es válido.");
        }

        // Mostrar los valores filtrados
        System.out.println("Filtrando por género: " + genre + " y precios entre: " + minPrice + " y " + maxPrice);
    }

    // Establecer la referencia al MainApp
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
}
