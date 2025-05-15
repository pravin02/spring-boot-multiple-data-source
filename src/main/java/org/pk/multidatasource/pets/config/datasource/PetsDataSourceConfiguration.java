package org.pk.multidatasource.pets.config.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PetsDataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.pets")
    public DataSourceProperties petsDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource petsDataSource() {
        return petsDataSourceProperties().initializeDataSourceBuilder().build();
    }

}
