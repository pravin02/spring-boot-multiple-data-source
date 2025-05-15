package org.pk.multidatasource.pets.config.datasource.jpa;


import org.pk.multidatasource.pets.entities.User;
import org.pk.multidatasource.pets.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = UserRepository.class,
        entityManagerFactoryRef = "petsEntityManagerFactory",
        transactionManagerRef = "petsTransactionManager"
)
public class PetsJPAConfiguration {

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean petsEntityManagerFactory(
            @Qualifier("petsDataSource") DataSource petsDataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(petsDataSource)
                .packages(User.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager petsTransactionManager(
            @Qualifier("petsEntityManagerFactory") LocalContainerEntityManagerFactoryBean petsEntityManager
    ) {
        return new JpaTransactionManager(Objects.requireNonNull(petsEntityManager.getObject()));
    }
}
