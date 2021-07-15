package com.example.AnotherTodo.dbServices;

import com.example.AnotherTodo.model.Task;
import com.example.AnotherTodo.services.JdbcService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDbService {

    private static final String INSERT_TASK_SQL = "INSERT INTO tasks (title, datetime, description) VALUES (?, ?, ?);";

    public void insertToDb(Task task){
        System.out.println(INSERT_TASK_SQL);
        try (
                Connection connection = JdbcService.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK_SQL)) {
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setTimestamp(2, task.getDateTime());
            preparedStatement.setString(3, task.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            JdbcService.printSQLException(exception);
        }
    }
}
