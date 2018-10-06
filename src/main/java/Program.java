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
