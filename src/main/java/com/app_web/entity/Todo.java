package com.app_web.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
/**
 *
 * @author Fagner
 */
@EntityScan
@DynamoDBDocument
@DynamoDBTable(tableName = "Todos")
public class Todo {
   
    @DynamoDBHashKey(attributeName="Id")
    private Long id;
    private String tarefa;
    private String descricao;
    private boolean realizado;

    public Todo() {

    }

    public Todo(Long id, String tarefa, String tarefaDescricao, boolean realizado) {
        this.id = id;
        this.tarefa = tarefa;
        this.descricao = tarefaDescricao;
        this.realizado = realizado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescrica(String descricao) {
        this.descricao = descricao;
    }

    public boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

}
