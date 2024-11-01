package hello;

import java.sql.*;

public class HelloWorld {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";

        Connection connection = DriverManager.getConnection(jdbcUrl);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM games");

        while (resultSet.next()) {
            String columnValue = resultSet.getString("name");
            System.out.println(columnValue);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}