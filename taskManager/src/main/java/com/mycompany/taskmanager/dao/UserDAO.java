package com.mycompany.taskmanager.dao;

import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

    public static User createUser(User user) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        String passwordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, passwordHash);

            int created = stmt.executeUpdate();
            if (created == 1) {
                return searchUser(user.getEmail());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static User validadeLogin(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String passwordHash = rs.getString("password");
                if (BCrypt.checkpw(password, passwordHash)) {
                    return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean updateUserName(int id, String name) {
        String sql = "UPDATE users SET name = ? WHERE id = ?";

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setInt(2, id);

            int update = stmt.executeUpdate();
            if (update == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean updateUserEmail(int id, String email) {
        String sql = "UPDATE users SET email = ? WHERE id = ?";

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setInt(2, id);

            int update = stmt.executeUpdate();
            if (update == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean updateUserPassword(int id, String password) {
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, passwordHash);
            stmt.setInt(2, id);

            int update = stmt.executeUpdate();
            if (update == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static User searchUser(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static User searchUser(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<User> listUsers() {
        String sql = "SELECT id, name, email FROM users";
        ArrayList<User> aL = new ArrayList();
        try (Connection cnn = ConnectionSQL.conectar(); Statement stmt = cnn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                aL.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aL;
    }

    public static boolean deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int del = stmt.executeUpdate();

            if (del == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
