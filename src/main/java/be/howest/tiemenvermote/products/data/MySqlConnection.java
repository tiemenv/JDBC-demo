package be.howest.tiemenvermote.products.data;

import be.howest.tiemenvermote.products.util.ProductsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String URL = "jdbc:mysql://localhost/shop?useSSL=false";
    private static final String USER = "jdbc";
    private static final String PWD = "jdbcdemo";

    public static Connection getConnection(){
        try {
            Connection con = DriverManager.getConnection(URL, USER, PWD);
            return con;
        } catch (SQLException ex){
            throw new ProductsException("Can't connect to DB", ex);
        }
    }
}
