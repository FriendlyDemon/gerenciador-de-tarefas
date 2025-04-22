/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.dao;

import com.mycompany.taskmanager.model.User;
import java.sql.SQLException;

/**
 *
 * @author HENRIQUEMICHEL
 */
public class TasksDAO {

    public static void createTask(String title, String description, String expiry, User user) {
        String sql = "INSERT INTO tasks (titulo,descricao,data_vencimento,userid) VALUES (?,?,?,?)";

        try () {
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        };
    }
}
