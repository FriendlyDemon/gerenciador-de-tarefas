package com.mycompany.taskmanager.dao;

import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.model.Task;
import com.mycompany.taskmanager.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TasksDAO {

    public static void createTask(Task task, User user) {
        String sql = "INSERT INTO tasks (titulo, descricao, data_vencimento, userid) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionSQL.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getExpiry());
            stmt.setInt(4, user.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        };
    }
}
