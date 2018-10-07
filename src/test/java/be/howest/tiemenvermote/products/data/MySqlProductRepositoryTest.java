package be.howest.tiemenvermote.products.data;

import be.howest.tiemenvermote.products.domain.Product;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class MySqlProductRepositoryTest {

    private MySqlProductRepository repo;

    @Before
    public void initRepoAndDb() throws IOException {
        initDb();
        repo = new MySqlProductRepository();
    }

    private static void initDb() throws IOException {
        Process process = Runtime.getRuntime().exec("./src/test/resources/resetDb.sh");
        java.util.Scanner s = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
        System.out.println(s.hasNext() ? s.next() : "");
        s = new java.util.Scanner(process.getErrorStream()).useDelimiter("\\A");
        System.out.println(s.hasNext() ? s.next() : "");
    }

    @Test
    public void getProducts() {
        //check length
        List<Product> ProductsInDB = repo.getProducts();
        assertEquals(16, ProductsInDB.size());
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
        assertEquals(16+1, repo.getProducts().size());
    }

    //TODO: goeie unittest?
    @Test
    public void updateProduct(){
        Product p = repo.getProduct("yoga 530");
        p.setPrice(959.99f);
        repo.updateProduct(p);
        assertEquals(p, repo.getProduct(p.getName()));
    }

    @AfterClass
    public static void resetDb() throws IOException{
        initDb();
    }
}