package com.mycompany.taskmanager.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

    private static final Connection connection = ConnectionSQL.conectar();

    private static void CreateUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS user ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(255) NOT NULL, "
                + "email VARCHAR(255) NOT NULL UNIQUE,"
                + "password VARCHAR(255) NOT NULL)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void CreateTaskTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Task ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "title VARCHAR(255) NOT NULL, "
                + "description TEXT, "
                + "due_date DATE, "
                + "status ENUM('pending', 'concluded') DEFAULT 'pending', "
                + "user_id INT, FOREIGN KEY (user_id) REFERENCES users (id)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
