package com.mycompany.taskmanager.model;

public class Task {

    private int id;
    private String title;
    private String description;
    private String due_date;
    private String status = "pending";
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        if (status) {
            this.status = "concluded";
        } else {
            this.status = "pending";
        }
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public Object[] getTableRow(){
    return new Object[]{id,title,description,due_date,status,user_id};
    }

    public Task(int id, String title, String description, String due_date, int user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.due_date = due_date;
        this.user_id = user_id;
    }

    public Task(int id, String title, String description, String due_date, boolean status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.due_date = due_date;
        if (status) {
            this.status = "concluded";
        }
    }

    public Task(int id, String title, String description, String due_date, boolean status, int user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.due_date = due_date;
        if (status) {
            this.status = "concluded";
        }

        this.user_id = user_id;
    }
}
