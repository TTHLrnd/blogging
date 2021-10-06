package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dbEngine {
    private Connection connection;

    public dbEngine() {
        connection = connect();
    }

    public boolean isConnected() {
        return (connection != null);
    }

    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/blogDatabase" +
                "?" +
                "useUnicode = yes" +
                "&" +
                "characterEncoding = UTF-8";

        Properties pr = new Properties();
        pr.put("user", System.getenv("USERNAME"));
        pr.put("password", System.getenv("PASSWORD"));

        try {
            return DriverManager.getConnection(url, pr);
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
            return null;
        }
    }


}
