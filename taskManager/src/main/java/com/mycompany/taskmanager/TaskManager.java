package com.mycompany.taskmanager;

import com.mycompany.taskmanager.dao.UserDAO;
import com.mycompany.taskmanager.model.User;

public class TaskManager {

    public static void main(String[] args) {
        User user = new User(0, "usuario", "usuario@email.com", "112233");
        UserDAO.createUser(user);

    }
}
