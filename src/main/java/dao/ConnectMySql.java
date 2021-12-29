package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMySql {
    public static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/productDemoMVC";
        String jdbcUsername = "root";
        String jdbcPassword = "12345678";
        Connection connection = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
