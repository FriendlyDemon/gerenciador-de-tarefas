package com.mycompany.taskmanager;

import com.mycompany.taskmanager.database.CreateTables;
import com.mycompany.taskmanager.view.Login;
import com.mycompany.taskmanager.view.MainFrame;

//User user = new User(1, "usuario", "usuario@email.com", "112233");
public class TaskManager {

    public static void main(String[] args) {
        //User user = new User(1, "usuario", "usuario@email.com", "112233");
        //TaskDAO.createTask(new Task(1, "lavar a louça", "lavar a louça da janta", "2025/04/24", 1), user);
        //TaskDAO.createTask(new Task(2, "lavar o chao", "lavar o chao da sala", "2025/04/24", true), user);
        //System.out.println(TaskDAO.searchTask("lavar o chao").getStatus());
        //System.out.println(TaskDAO.searchTask("lavar a louça").getStatus());
//        CreateTables.CreateTaskTable();
//        CreateTables.CreateUserTable();
        new MainFrame(new Login()).setVisible(true);
    }
}
