package org.pk.multidatasource.todos.config.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class TodosDataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.todos")
    public DataSourceProperties todosDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource todosDataSource() {
        return todosDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
