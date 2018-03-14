package com.airlims.enterprise.applications.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.airlims.enterprise.applications.data.repository.lims",
        entityManagerFactoryRef = "limsEntityManager",
        transactionManagerRef = "limsTransactionManager",
        repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class
)
public class LimsDBConfig {

    @Autowired
    private Environment env;

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean limsEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(limsDataSource());
        em.setPackagesToScan(
                new String[] { "com.airlims.enterprise.applications.data.entity.lims" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("lims.jdbc.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("lims.jdbc.hibernate.dialect"));
        properties.put("hibernate.dbcp.testWhileIdle", env.getProperty("lims.jdbc.hibernate.dbcp.testWhileIdle"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean
    public DataSource limsDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("lims.jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("lims.jdbc.url"));
        dataSource.setUsername(env.getProperty("lims.jdbc.username"));
        dataSource.setPassword(env.getProperty("lims.jdbc.password"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager limsTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                limsEntityManager().getObject());
        return transactionManager;
    }
}
