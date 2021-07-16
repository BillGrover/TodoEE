package com.example.AnotherTodo.daos;

import com.example.AnotherTodo.model.User;
import com.example.AnotherTodo.services.JdbcService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private static final String INSERT_USER_SQL =
            "INSERT INTO users (username, password, firstname, surname, email, phone, telegram, birthday, registration_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public void insertToDb(User user) {
        System.out.println(INSERT_USER_SQL);
        try (
                Connection connection = JdbcService.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getSurname());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getTelegram());
            preparedStatement.setTimestamp(8, user.getBirthday());
            preparedStatement.setTimestamp(9, user.getRegistrationDate());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            JdbcService.printSQLException(exception);
        }
    }

    public void createTableIfAbsent(){
        try{
            Connection connection = JdbcService.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS users " +
                            "(id SERIAL NOT NULL PRIMARY KEY," +
                            "username varchar(25) NOT NULL UNIQUE," +
                            "password varchar(25) NOT NULL UNIQUE," +
                            "firstname varchar(25)," +
                            "surname varchar(25)," +
                            "email varchar(25)," +
                            "phone varchar(25)," +
                            "telegram varchar(25)," +
                            "birthday timestamp," +
                            "registration_date timestamp)");
            ps.executeUpdate();
            ps.close();
        }catch (SQLException exception) {
            JdbcService.printSQLException(exception);
        }
    }
}
