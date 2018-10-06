package be.howest.tiemenvermote.products.data;

import be.howest.tiemenvermote.products.domain.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MySqlProductRepositoryTest {

    private MySqlProductRepository repo;

    @Before
    public void initRepo(){
        repo = new MySqlProductRepository();
    }

    @Test
    public void getProducts() {
        //check length
        List<Product> ProductsInDB = repo.getProducts();
        assertEquals(8, ProductsInDB.size());
    }

    @Test
    public void getProduct(){
        Product p = new Product ("XPS", 4199.99f);
        assertEquals(p, repo.getProduct(p.getName()));
    }

    @Test
    public void addProduct(){
        Product p = new Product ("yoga 730", 1299.99f);
        repo.addProduct(p);
        assertEquals(8+1, repo.getProducts().size());
    }
}