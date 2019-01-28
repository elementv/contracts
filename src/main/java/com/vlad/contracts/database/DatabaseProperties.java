package com.vlad.contracts.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {
    private String username;
    private String password;
    private String databaseName;
    private String serverName;
    private String hibernateDialect;
    private String hibernateDdlAuto;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getHibernateDialect() {
        return hibernateDialect;
    }

    public void setHibernateDialect(String hibernateDialect) {
        this.hibernateDialect = hibernateDialect;
    }

    public String getHibernateDdlAuto() {
        return hibernateDdlAuto;
    }

    public void setHibernateDdlAuto(String hibernateDdlAuto) {
        this.hibernateDdlAuto = hibernateDdlAuto;
    }
}
