/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TALITANAIBERTDACOSTA
 */
public class CreateTables {
    
      private static Connection connection= ConnectionSQL.conectar();
      
    private static void CreateUsersTable(){
        String sql = "CREATE TABLE IF NOT EXISTS user ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "user VARCHAR(255) NOT NULL UNIQUE, "
                + "email VARCHAR(255) NOT NULL,"
                + "password VARCHAR(255) NOT NULL)";
        
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela", e);
        }
    }
    
  }

