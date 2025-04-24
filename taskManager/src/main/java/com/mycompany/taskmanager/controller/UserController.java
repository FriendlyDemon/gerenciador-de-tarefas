package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.dao.UserDAO;
import com.mycompany.taskmanager.model.User;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class UserController {

    public static User createUser(String name, String email, char[] password) {
        return UserDAO.createUser(new User(0, name, email, new String(password)));
    }

    public static User validateUser(String email, char[] password) {
        return UserDAO.validadeLogin(email, new String(password));
    }

    public static boolean updateUserName(int id, String name) {
        return UserDAO.updateUserName(id, name);
    }

    public static boolean updateUserEmail(int id, String email) {
        return UserDAO.updateUserEmail(id, email);
    }

    public static boolean updateUserPassword(int id, char[] password) {
        return UserDAO.updateUserPassword(id, new String(password));
    }

    public static User searchUser(String email) {
        return UserDAO.searchUser(email);
    }

    public static void listUsers(DefaultTableModel model) {
        ArrayList<User> aL = UserDAO.listUsers();
        if (!aL.isEmpty()) {
            model.setRowCount(0);
            for (User user : aL) {
                model.addRow(user.getTableRow());
            }
        }
    }

    public static boolean deleteUser(int id) {
        return UserDAO.deleteUser(id);
    }
}
