package com.bitsco.vks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private final Environment env; // Contains Properties Load by @PropertySources

    @Autowired
    public DataSourceConfig(Environment env) {
        this.env = env;
    }
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(env.getProperty("spring.datasource.driver.class"));
        dataSourceBuilder.url(env.getProperty("spring.datasource.url"));
        dataSourceBuilder.username(env.getProperty("spring.datasource.username"));
        dataSourceBuilder.password(env.getProperty("spring.datasource.password"));
        System.out.println(env.getProperty("spring.datasource.driver.class"));
        System.out.println(env.getProperty("spring.datasource.url"));
        System.out.println(env.getProperty("spring.datasource.username"));
        System.out.println(env.getProperty("spring.datasource.password"));
        return dataSourceBuilder.build();
    }
}