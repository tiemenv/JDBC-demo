package be.howest.tiemenvermote.products.util;

public class ProductsException extends RuntimeException {
    public ProductsException(String msg, Exception innerException) {
        super(msg, innerException);
    }
    public ProductsException(String msg) {super(msg);}
}
