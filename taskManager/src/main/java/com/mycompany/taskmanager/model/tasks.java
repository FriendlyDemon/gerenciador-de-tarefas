/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.model;

/**
 *
 * @author HENRIQUEMICHEL
 */
public class tasks {

    private int id;
    private String titulo;
    private String descricao;
    private String data_venciomento;

    public tasks(int id, String titulo, String descricao, String data_venciomento) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data_venciomento = data_venciomento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_venciomento() {
        return data_venciomento;
    }

    public void setData_venciomento(String data_venciomento) {
        this.data_venciomento = data_venciomento;
    }
}
