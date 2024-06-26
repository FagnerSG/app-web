package com.app_web;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.app_web.entity.Todo;

@Component
public class DynamoDBInitializer {

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private DynamoDBMapperConfig dynamoDBMapperConfig;

    @PostConstruct
    public void init() {
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB, dynamoDBMapperConfig);
        
        Class<?>[] modelClasses = new Class<?>[] {
            Todo.class
        };

        for (Class<?> clazz : modelClasses) {
            CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(clazz);
            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

            try {
                TableDescription createdTable = amazonDynamoDB.createTable(tableRequest).getTableDescription();
                System.out.println("Created table: " + createdTable.getTableName());
            } catch (Exception e) {
                // Aqui você pode tratar exceções específicas, como se a tabela já existe
                System.err.println("Table already exists: " + clazz.getSimpleName());
            }
        }

        //CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Todo.class);
        //amazonDynamoDB.createTable(tableRequest);
    }
}

