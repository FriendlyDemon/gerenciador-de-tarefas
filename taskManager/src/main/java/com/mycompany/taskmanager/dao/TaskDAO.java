package com.mycompany.taskmanager.dao;

import com.mycompany.taskmanager.database.ConnectionSQL;
import com.mycompany.taskmanager.model.Task;
import com.mycompany.taskmanager.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TaskDAO {

    public static boolean createTask(Task task) {
        String sql = "INSERT INTO tasks (title, description, due_date, status, user_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getDue_date());
            stmt.setString(4, task.getStatus());
            stmt.setInt(5, task.getUser_id());

            int created = stmt.executeUpdate();
            if (created == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public static boolean updateTaskTitle(int id, String title) {
        String sql = "UPDATE tasks SET title = ? WHERE id = ?";

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, title);
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

    public static boolean updateTaskDescription(int id, String description) {
        String sql = "UPDATE tasks SET description = ? WHERE id = ?";

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, description);
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

    public static boolean updateTaskDue_date(int id,String due_date) {
        String sql = "UPDATE tasks SET due_date = ? WHERE id = ?";

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, due_date);
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

    public static boolean updateTaskStatus(int id,String status) {
        String sql = "UPDATE tasks SET status = ? WHERE id = ?";

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setString(1, status);
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

    public static boolean updateTaskUser(int id, int user_id) {
        String sql = "UPDATE tasks SET user_id = ? WHERE id = ?";

        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {

            stmt.setInt(1, user_id);
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

    public static Task searchTask(String title) {
        String sql = "SELECT * FROM tasks WHERE title = ?";
        try (Connection cnn = ConnectionSQL.conectar(); PreparedStatement stmt = cnn.prepareStatement(sql)) {
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Task(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getString("due_date"), rs.getString("status").equals("concluded"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Task> listTasks() {
        String sql = "SELECT * FROM tasks";
        ArrayList<Task> aL = new ArrayList();
        try (Connection cnn = ConnectionSQL.conectar(); Statement stmt = cnn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                aL.add(new Task(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getString("due_date"), rs.getString("status").equals("concluded")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aL;
    }

    public static boolean deleteTask(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";

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
