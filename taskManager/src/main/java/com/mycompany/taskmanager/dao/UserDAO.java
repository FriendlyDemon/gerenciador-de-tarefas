package com.mycompany.taskmanager.dao;

import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

    public static void createUser(User user) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        String passwordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try (Connection connection = ConnectionSQL.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, passwordHash);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean validadeLogin(User user) {
        String sql = "SELECT password FROM user WHERE email = ?";

        try (Connection connection = ConnectionSQL.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, user.getEmail());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String passwordHash = rs.getString("password");
                return BCrypt.checkpw(user.getPassword(), passwordHash);
            }
        } catch (SQLException e) {
        }
        return false;
    }

    public static void updateUserName(User user) {
        String sql = "UPDATE users SET name = ? WHERE id = ?";

        try (Connection connection = ConnectionSQL.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void updateUserEmail(User user) {
        String sql = "UPDATE users SET email = ? WHERE id = ?";

        try (Connection connection = ConnectionSQL.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, user.getEmail());
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void updateUserPassword(User user) {
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        String passwordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try (Connection connection = ConnectionSQL.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, passwordHash);
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void deleteUser(User user) {
    }
}
