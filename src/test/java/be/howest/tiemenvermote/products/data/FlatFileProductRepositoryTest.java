package be.howest.tiemenvermote.products.data;

import be.howest.tiemenvermote.products.domain.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlatFileProductRepositoryTest {

    private FlatFileProductRepository repo;

    @Before
    public void initRepo(){
        repo = new FlatFileProductRepository();
    }

    @Test
    public void getProducts(){
        ArrayList<Product> products = repo.getProducts();
        assertEquals(3, products.size());
    }

    @Test
    public void getProduct(){
        Product p = repo.getProduct("XPS");
        Product pExcepted = new Product("XPS", 3199.99f);
        assertEquals(p, pExcepted);
    }
}
