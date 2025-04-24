package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.dao.TaskDAO;
import com.mycompany.taskmanager.dao.UserDAO;
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

    public static void searchTask(String title, DefaultTableModel model, User user) {
        Task task;
        String titleLIKE = "%" + title + "%";
        if ("admin".equals(user.getEmail())) {
            task = TaskDAO.searchTask(titleLIKE);
        } else {
            task = TaskDAO.searchTask(titleLIKE, user.getId());
        }
        model.setRowCount(0);
        Object[] row = task.getTableRow();
        User userName = UserDAO.searchUser(task.getUser_id());
        if (userName != null) {
            row[5] = userName.getName();
        } else {
            row[5] = null;
        }
        model.addRow(row);
    }

    public static void listTasks(DefaultTableModel model, User user_) {
        ArrayList<Task> aL;
        if ("admin".equals(user_.getEmail())) {
            aL = TaskDAO.listTasks();
        } else {
            aL = TaskDAO.listTasks(user_.getId());
        }

        if (!aL.isEmpty()) {
            model.setRowCount(0);
            for (Task task : aL) {
                Object[] row = task.getTableRow();
                User user = UserDAO.searchUser(task.getUser_id());
                if (user != null) {
                    row[5] = user.getName();
                } else {
                    row[5] = null;
                }
                model.addRow(row);
            }
        }
    }

    public static boolean deleteTask(int id) {
        return TaskDAO.deleteTask(id);
    }

}
