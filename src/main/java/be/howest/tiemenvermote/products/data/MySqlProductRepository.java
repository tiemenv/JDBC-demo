package be.howest.tiemenvermote.products.data;

import be.howest.tiemenvermote.products.domain.Product;
import be.howest.tiemenvermote.products.util.ProductsException;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductRepository implements ProductRepository {

    private static final String SQL_ADD_PRODUCT = "insert into products(name, price) values(?,?)";
    private static final String SQL_GET_PRODUCTS = "select * from products";
    private static final String SQL_GET_PRODUCT = "select * from products where name like ?";

    @Override
    public void addProduct(Product p) {

        System.out.println("Attempting update");
        try (PreparedStatement prep = MySqlConnection.getConnection().prepareStatement(SQL_ADD_PRODUCT)) {
            prep.setString(1, p.getName());
            prep.setFloat(2, p.getPrice());
            prep.executeUpdate();
            System.out.println("Updated");
        } catch (SQLException ex) {
            throw new ProductsException("Unable to add book to DB", ex);
        }
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try (
                PreparedStatement prep = MySqlConnection.getConnection().prepareStatement(SQL_GET_PRODUCTS)

        ) {

            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    float price = rs.getFloat("price");
                    Product p = new Product(name, price);
                    products.add(p);

                }
                return products;
            }
        } catch (SQLException ex) {
            throw new ProductsException("Unable to fetch products from DB", ex);
        }

    }

    @Override
    public Product getProduct(String name) {
        Product p;
        float price = 0f;
        try (
                PreparedStatement prep = MySqlConnection.getConnection().prepareStatement(SQL_GET_PRODUCT)
        ) {
            prep.setString(1, name);
            System.out.println("Got this far");
            try (ResultSet rs = prep.executeQuery()) {
                if(rs.next()) {
                    price = rs.getFloat("price");
                }
                p = new Product(name, price);
                return p;
            }
        } catch (SQLException ex) {
            throw new ProductsException("Can't fetch product from DB", ex);
        }
    }

    @Override
    public void updateProduct(Product p) {

    }

    @Override
    public void deleteProduct(Product p) {

    }
}
