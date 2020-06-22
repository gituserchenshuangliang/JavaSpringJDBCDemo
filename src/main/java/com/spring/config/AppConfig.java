package com.spring.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @description:Java配置类
 * @author: Cherry
 * @time: 2020/6/8 9:17
 */
@Configuration
@ComponentScan
@PropertySource(value = "classpath:config/db.properties",ignoreResourceNotFound = true)
@EnableTransactionManagement
public class AppConfig implements TransactionManagementConfigurer {
    private DataSource dataSource;

    @Value("${jdbc.database.driver}")
    private String driver = null;

    @Value("${jdbc.database.url}")
    private String url = null;

    @Value("${jdbc.database.username}")
    private String username = null;

    @Value("${jdbc.database.password}")
    private String password = null;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        if (dataSource != null) return dataSource;
        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }



    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbc = new JdbcTemplate();
        jdbc.setDataSource(getDataSource());
        return jdbc;
    }

    @Override
    @Bean(name = "tansactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(getDataSource());
        return manager;
    }
}
