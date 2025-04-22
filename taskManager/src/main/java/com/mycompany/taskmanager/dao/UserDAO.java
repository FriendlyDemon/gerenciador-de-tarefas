package com.mycompany.taskmanager.dao;

import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

    public static void createUser(User user) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        String senhaHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try (Connection connection = ConnectionSQL.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, senhaHash);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        };
    }
}
