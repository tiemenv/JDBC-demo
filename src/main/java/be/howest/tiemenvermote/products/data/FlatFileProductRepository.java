package be.howest.tiemenvermote.products.data;

import be.howest.tiemenvermote.products.domain.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Float.parseFloat;

public class FlatFileProductRepository implements ProductRepository {

    //Storage convention:
    //Each field of the product to be saved should be written to a new line, getProducts uses this convention to construct new objects from the flatfile
    private File f = new File("products.json");

    @Override
    public void addProduct(Product p) {
        try {
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintStream ps = new PrintStream(fos);
            ps.println(p.getName());
            ps.println(p.getPrice());
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public Product getProduct(String name) {
        for(Product product : this.getProducts()){
            if(product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(f);
                Scanner s = new Scanner(fis);
        ) {
            while (s.hasNextLine()) {
                String pName = s.nextLine();
                float pPrice = parseFloat(s.nextLine());
                products.add(new Product(pName, pPrice));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void updateProduct(Product p) {
        System.out.println("updateProduct is not supported in the flatfile system");
    }

    @Override
    public void deleteProduct(Product p) {
        System.out.println("deleteProduct is not supported in the flatfile system");
    }

}
