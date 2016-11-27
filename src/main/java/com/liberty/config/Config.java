package com.liberty.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * Created by Dmytro_Kovalskyi on 28.03.2016.
 */
@Configuration
@ComponentScan("com.liberty")
@EnableWebSocket
@EnableMongoRepositories("com.liberty.repositories")
public class Config extends AbstractMongoConfiguration {

    @Autowired
    private DbConfiguration dbConfiguration;

    private static final String REPOSITORIES_PACKAGE = "com.liberty.model";
    public static final int POOL_SIZE = 5;

    @Override
    protected String getDatabaseName() {
        return dbConfiguration.getDbName();
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(
                dbConfiguration.getDbHost(), dbConfiguration.getDbPort()
        );
    }

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getMappingBasePackage() {
        return REPOSITORIES_PACKAGE;
    }
}