package be.howest.tiemenvermote.products.ui.gui;

import be.howest.tiemenvermote.products.data.Repositories;
import be.howest.tiemenvermote.products.domain.Product;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ManageProducts {

    public static ObservableList<Product> observableProductsList;

    @FXML
    private ListView<Product> lstProducts;

    @FXML
    private Label lblProducts;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnExit;

    @FXML
    void addProduct(ActionEvent event) throws IOException {
        Product newProduct = dialogAddProduct(null);
        Repositories.getInstance().getProductRepository().addProduct(newProduct);
        observableProductsList.add(newProduct);
    }

    @FXML
    void updateProduct(ActionEvent event) {
        System.out.println("update");
        Product product = lstProducts.getSelectionModel().getSelectedItem();
        System.out.println(product);
    }

    //TODO: automatically recognize whether product should be added or updated
    Product dialogAddProduct(Product p) throws IOException {
        URL fxmlURL = ClassLoader.getSystemResource("fxml/ProductDetail.fxml");
        FXMLLoader rootLoader = new FXMLLoader(fxmlURL);
        Pane root = rootLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        ProductDetail ctrl = rootLoader.getController();
        ctrl.setCurrentStage(stage);
        stage.showAndWait();
        return ctrl.getP();
    }



    @FXML
    void deleteProduct(ActionEvent event) {
        Product product = lstProducts.getSelectionModel().getSelectedItem();
        Repositories.getInstance().getProductRepository().deleteProduct(product);
        observableProductsList.remove(product);
    }

    @FXML
    void exitApplication(ActionEvent event) {
        Platform.exit();
    }


    @FXML
    public void initialize() {
        List<Product> products = Repositories.getInstance().getProductRepository().getProducts();
        observableProductsList = FXCollections.observableArrayList(products);
        lstProducts.setItems(observableProductsList);
    }
}
