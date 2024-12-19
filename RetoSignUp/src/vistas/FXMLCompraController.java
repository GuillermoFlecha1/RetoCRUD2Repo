package vistas;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class FXMLCompraController {

    private Main mainApp;  // Aquí se mantiene la referencia a MainApp

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private TextField minPriceField;

    @FXML
    private TextField maxPriceField;

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

        // Configurar eventos de botones
        searchButton.setOnMouseClicked(this::handleSearch);
        dateButton.setOnMouseClicked(this::handleDate);
        filterButton.setOnMouseClicked(this::handleFilter);
    }

    // Método para establecer el mainApp
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    // Evento para realizar la búsqueda
    private void handleSearch(MouseEvent event) {
        String query = searchField.getText();
        System.out.println("Buscando: " + query);
    }

    // Evento para seleccionar la fecha
    private void handleDate(MouseEvent event) {
        System.out.println("Lanzar DatePicker");
        // Implementa el DatePicker según lo necesario
    }

    // Evento para aplicar el filtro
    private void handleFilter(MouseEvent event) {
        String genre = genreComboBox.getValue();
        String minPrice = minPriceField.getText();
        String maxPrice = maxPriceField.getText();
        
        System.out.println("Filtrando por género: " + genre);
        System.out.println("Rango de precios: " + minPrice + " - " + maxPrice);
    }
}
