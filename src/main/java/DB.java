import java.sql.*;

public class DB {
    private static final String URL = "jdbc:mysql://localhost/shop?useSSL=false";
    private static final String USER = "jdbc";
    private static final String PWD = "jdbcdemo";

    public static void main(String[] args) {
        new DB().run("XPS");
    }

    private void run(String laptop) {
        try (Connection con = DriverManager.getConnection(URL, USER, PWD)) {
            String SQL = "select * from products where name like ?";
            try (
                    PreparedStatement prep = con.prepareStatement(SQL)

            ) {
                prep.setString(1, "%" + laptop + "%");
                try (ResultSet rs = prep.executeQuery()) {
                    while (rs.next()) {
                        String name = rs.getString("name");
                        float price = rs.getFloat("price");

                        System.out.println(name + ": EUR" + price);
                    }
                }
            }

            SQL = "insert into products(name, price) values(?,?)";
            System.out.println("Attempting update");
            try(PreparedStatement prep = con.prepareStatement(SQL)){
                prep.setString(1, "B5400");
                prep.setFloat(2, 349.99f);
                prep.executeUpdate();
                System.out.println("Updated");
            }
        } catch (SQLException ex) {
    ex.printStackTrace();
        }
    }


}

