package be.howest.tiemenvermote.products.ui.gui;

import be.howest.tiemenvermote.products.domain.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProductDetail {


    private Product p;

    public void setCurrentStage (Stage currentStage) {
        this.currentStage = currentStage;
    }

    private Stage currentStage;

    public Product getP() {
        return p;
    }

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    void cancel(ActionEvent event) {
        System.out.println("cancel");
        currentStage.close();
    }

    @FXML
    void ok(ActionEvent event) {
        System.out.println("ok");
        String nameString = txtName.getText();
        String priceAsString = txtPrice.getText();
        if (!nameString.equals("") && !priceAsString.equals("")) {
            String name = nameString;
            try {
                float price = Float.parseFloat(priceAsString);
                p = new Product(name, price);
            } catch (Exception ex) {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setContentText("Error004");
                al.showAndWait();
            }
        }
        currentStage.close();
    }

}

