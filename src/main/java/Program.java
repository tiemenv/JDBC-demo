import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class Program extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlURL = ClassLoader.getSystemResource("fxml/ManageProducts.fxml");
        FXMLLoader rootLoader = new FXMLLoader(fxmlURL);
        Pane root = rootLoader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }
}
