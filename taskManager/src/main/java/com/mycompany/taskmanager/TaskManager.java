package com.mycompany.taskmanager;

import com.mycompany.taskmanager.database.CreateTables;
import com.mycompany.taskmanager.view.Login;
import com.mycompany.taskmanager.view.MainFrame;

//User user = new User(1, "usuario", "usuario@email.com", "112233");
public class TaskManager {

    public static void main(String[] args) {
        CreateTables.CreateUserTable();
        CreateTables.CreateTaskTable();

        new MainFrame(new Login()).setVisible(true);
    }
}
