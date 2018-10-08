import be.howest.tiemenvermote.products.data.ProductRepository;
import be.howest.tiemenvermote.products.data.Repositories;
import be.howest.tiemenvermote.products.domain.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Program extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/ManageProducts.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void run(){
        ProductRepository repo = Repositories.getInstance().getProductRepository();
        for(Product p : repo.getProducts()){
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        }
        Product p = new Product("test", 22.33f);
        repo.addProduct(p);
        System.out.println(repo.getProduct("yoga").getPrice());
        Product p2 = new Product("XPS", 4299.99f);
        repo.updateProduct(p2);
        repo.deleteProduct(p);

    }
}
