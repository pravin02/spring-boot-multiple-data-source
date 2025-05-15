# spring-boot-multiple-data-source

### This application demonstrates how one spring boot application can have multiple data sources.

For one data source steps are pretty simple include `spring-boot-starter-jpa` & database driver in our case `postgresql`
in pom.xml
and add few properties in application.yaml file.
` 
spring:
    datasource:
        url: jdbc:postgresql://localhost:5432/database_name
        username: postgres
        password: postgres
        driverClassName: org.postgresql.Driver
`

For multiple datasource we need to tweak the configuration as below,

1. Add pets and todos database names
   ` 
   spring:
       datasource:
           pets:
               url: jdbc:postgresql://localhost:5432/database_name
               username: postgres
               password: postgres
               driverClassName: org.postgresql.Driver
           todos:
               url: jdbc:postgresql://localhost:5432/todos
               username: postgres
               password: postgres
               driverClassName: org.postgresql.Driver
   `
2. By default, spring.datasource.* properties assigned to
   `org.springframework.boot.autoconfigure.jdbc.DataSourceProperties` class.
3. We need to assign pets and todos in custom bean like `PetsDataSourceConfiguration` & `TodosDataSourceConfiguration`
4. Out those properties need to create datasource bean.
5. As we're using JPA so will have to define multiple JPAConfigurations for each datasource like
   `PetsJPAConfiguration` &
   `TodosJPAConfiguration`.
6. Note DataSource & EntityManagerFactory needed at least on primary to boot up the application.
7. `@EnableJpaRepositories` annotation has basePackageClasses attribute need to assign repositories list which are
   belongs
   to that database along with entityManager & transactionManager references.

### How To Test

1. Start the application on post 8080
2. Launch browser and enter http://localhost:8080/swagger-ui/index.html
3. Add update the records and check database entries.