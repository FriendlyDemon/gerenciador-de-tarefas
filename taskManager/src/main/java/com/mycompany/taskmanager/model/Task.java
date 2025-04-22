package com.mycompany.taskmanager.model;

public class Task {

    private int id;
    private String title;
    private String description;
    private String expiry;
    private String status = "pendente";

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

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        if (status) {
            this.status = "concluido";
        } else {
            this.status = "pendente";
        }
    }

    public Task(int id, String title, String description, String expiry) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.expiry = expiry;
    }
}
