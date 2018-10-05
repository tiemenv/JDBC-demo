package be.howest.tiemenvermote.products.data;

public class Repositories {
    private static Repositories instance = new Repositories();

    public static Repositories getInstance() {
        return instance;
    }

    private Repositories() {
    }

    public ProductRepository getProductRepository() {
        return new MySqlProductRepository();
    }
}
