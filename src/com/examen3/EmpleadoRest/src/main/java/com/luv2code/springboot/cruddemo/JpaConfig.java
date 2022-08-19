/*	Becerril Becerril Daniel
 * 	Proyecto Api Rest Empleados
 * 	19/08/2022
 * 	Recurso de la configuración de BD para JDBC
 * */
package com.luv2code.springboot.cruddemo;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JpaConfig {
//    @Bean(name = "h2DataSource")
//    public DataSource h2DataSource()
//    {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:file:C:/temp/test");
//        dataSourceBuilder.username("sa");
//        dataSourceBuilder.password("");
//        return dataSourceBuilder.build();
//    }
	//https://howtodoinjava.com/spring-boot2/datasource-configuration/
    @Bean(name = "mySqlDataSource")
    @Primary
    public DataSource mySqlDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/web_student_tracker?useSSL=false&serverTimezone=UTC");
        dataSourceBuilder.username("webstudent");
        dataSourceBuilder.password("webstudent");
        return dataSourceBuilder.build();
    }
}