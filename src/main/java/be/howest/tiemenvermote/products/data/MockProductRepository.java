package be.howest.tiemenvermote.products.data;

import be.howest.tiemenvermote.products.domain.Product;
import be.howest.tiemenvermote.products.util.ProductsException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MockProductRepository implements ProductRepository  {

    private final Set<Product> products;

    public MockProductRepository(){
        products = new HashSet<>();
        products.add(new Product("yoga 530", 799.99f));
        products.add(new Product("XPS", 2799.99f));
        products.add(new Product("B5400", 349.99f));

    }
    @Override
    public void addProduct(Product p) {
    boolean added = products.add(p);
    //TODO: welk soort expectie moet ik hier throwen? Deze exceptie verwacht msg en innerException
    if (!added) {
        throw new ProductsException("Failed to add book");
    }
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    //TODO: hoe dit implementeren? Zoeken in een Set????? Beter andere Collection?
    @Override
    public Product getProduct(String name) {
        return null;
    }

    @Override
    public void updateProduct(Product p) {
        //TODO: waarom hier "do nothing"?
    }

    @Override
    public void deleteProduct(Product p) {
        products.remove(p);
    }
}
