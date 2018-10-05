import be.howest.tiemenvermote.products.data.ProductRepository;
import be.howest.tiemenvermote.products.data.Repositories;
import be.howest.tiemenvermote.products.domain.Product;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run(){
        ProductRepository repo = Repositories.getInstance().getProductRepository();
        for(Product p : repo.getProducts()){
            System.out.println(p.getName());
        }
        Product p = new Product("test", 22.33f);
        repo.addProduct(p);
        System.out.println(repo.getProduct("yoga").getPrice());
    }
}