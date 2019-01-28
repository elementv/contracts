package com.vlad.contracts.database;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.vlad.contracts"})
public class DatabaseConfiguration {
    @Autowired
    private DatabaseProperties databaseProperties;

    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser(databaseProperties.getUsername());
        dataSource.setPassword(databaseProperties.getPassword());
        dataSource.setDatabaseName(databaseProperties.getDatabaseName());
        dataSource.setServerName(databaseProperties.getServerName());
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.vlad.contracts.database");
        sessionFactory.setHibernateProperties(hibernateProperties());
        System.out.println("Session factory was created.");
        return sessionFactory;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", databaseProperties.getHibernateDdlAuto());
        hibernateProperties.setProperty(
                "hibernate.dialect", databaseProperties.getHibernateDialect());
        return hibernateProperties;
    }

    // copied from https://www.baeldung.com/hibernate-5-spring
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
