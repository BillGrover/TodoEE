package com.example.AnotherTodo.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcService {

    //TODO: вынести настройки в пропертис
    private static String jdbcUrl = "jdbc:postgresql://localhost:5432/todo_ee_db";
    private static String jdbcUsername = "postgres";
    private static String jdbcPassword = "Dudun27526976&";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
            System.out.println("connection established");
        } catch (SQLException e) {
            // TODO logging and logic
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO logging and logic
            e.printStackTrace();
        }
        return connection;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
