package be.howest.tiemenvermote.products.ui.gui;

import be.howest.tiemenvermote.products.data.Repositories;
import be.howest.tiemenvermote.products.domain.Product;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.text.html.Option;
import javax.xml.soap.Text;
import java.util.List;
import java.util.Observable;
import java.util.Optional;

public class ManageProducts {


    private ObservableList<Product> observableProductsList;

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
    void addProduct(ActionEvent event) {
        //TODO: variabelen krijgen default values mee, dus bij error komt er wel een nieuw product id db met deze default values, hoe beter opvangen?
        String name = "";
        float price = 0f;
        System.out.println("add");
        TextInputDialog tid = new TextInputDialog();
        tid.setHeaderText("Enter product name");
        Optional<String> nameString = tid.showAndWait();
        if (nameString.isPresent()){
            name = nameString.get();
        } else {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setContentText("Error001");
            al.showAndWait();
        }
        TextInputDialog nid = new TextInputDialog();
        nid.setHeaderText("Set price");
        Optional<String> priceAsString = nid.showAndWait();
        if(priceAsString.isPresent()){
            price = Float.parseFloat(priceAsString.get());
        } else {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setContentText("Error002");
            al.showAndWait();
        }
        Product p = new Product(name, price);
        Repositories.getInstance().getProductRepository().addProduct(p);
        initialize();
    }

    @FXML
    void deleteProduct(ActionEvent event) {
        System.out.println("delete");
    }

    @FXML
    void exitApplication(ActionEvent event) {
        System.out.println("exit");
        Platform.exit();
    }

    @FXML
    void updateProduct(ActionEvent event) {
        System.out.println("update");
    }

    @FXML
    public void initialize(){
        List<Product> products = Repositories.getInstance().getProductRepository().getProducts();
        observableProductsList = FXCollections.observableArrayList(products);
        lstProducts.setItems(observableProductsList);
    }



}
