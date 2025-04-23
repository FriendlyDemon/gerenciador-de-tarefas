package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.dao.TaskDAO;
import com.mycompany.taskmanager.model.Task;
import com.mycompany.taskmanager.model.User;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class TaskController {

    public static boolean createTask(String title, String description, String due_date, boolean status, User user) {
        Task newTask = new Task(0, title, description, due_date, user.getId());
        return TaskDAO.createTask(newTask);
    }

    public static boolean updateTaskTitle(int id, String title) {
        return TaskDAO.updateTaskTitle(id, title);
    }

    public static boolean updateTaskDescription(int id, String description) {
        return TaskDAO.updateTaskDescription(id, description);
    }

    public static boolean updateTaskDue_date(int id, String due_date) {
        return TaskDAO.updateTaskDue_date(id, due_date);
    }

    public static boolean updateTaskStatus(int id, boolean status) {
        String sStatus = "pending";
        if (status) {
            sStatus = "concluded";
        }
        return TaskDAO.updateTaskStatus(id, sStatus);
    }

    public static boolean updateTaskUser(int id, int user_id) {
        return TaskDAO.updateTaskUser(id, user_id);
    }

    public static Task searchTask(String title) {
        return TaskDAO.searchTask(title);
    }

    public static void searchTask(String title, DefaultTableModel model) {
        Task task = TaskDAO.searchTask(title);
        model.setRowCount(0);
        model.addRow(task.getTableRow());
    }

    public static void listTasks(DefaultTableModel model) {
        ArrayList<Task> aL = TaskDAO.listTasks();
        for (Task task : aL) {
            model.addRow(task.getTableRow());
        }
    }

    public static boolean deleteTask(int id) {
        return TaskDAO.deleteTask(id);
    }

}
