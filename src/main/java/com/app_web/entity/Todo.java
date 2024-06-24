package com.app_web.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@DynamoDBTable(tableName = "Todos")
public class Todo {

    @DynamoDBHashKey(attributeName = "id")
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

}
