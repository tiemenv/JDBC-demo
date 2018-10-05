package be.howest.tiemenvermote.products.data;

import be.howest.tiemenvermote.products.domain.Product;

import java.util.List;

public interface ProductRepository {

    void addProduct(Product p);
    List<Product> getProducts();
    Product getProduct(String name);
    void updateProduct(Product p);
    void deleteProduct(Product p);


}
