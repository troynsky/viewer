package ru.cbr.config;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

@Configuration
@PropertySource(value = {"classpath:application.properties"}, ignoreResourceNotFound = true)
@EnableJpaRepositories(basePackages = {"ru.cbr.repository"})
@ComponentScan({"ru.cbr.dao"})
@EnableTransactionManagement
@Import({DataSourceConfig.class})
public class Config {

    final static Logger log = LoggerFactory.getLogger(Config.class);

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[]{"ru.cbr.model"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaDialect(new HibernateJpaDialect());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty(AvailableSettings.HBM2DLL_CREATE_SCHEMAS, Boolean.TRUE.toString());
        try {
            Connection connection = dataSource.getConnection();
            try {
                final String databaseProductName = connection.getMetaData().getDatabaseProductName();
                Class<? extends Dialect> dialectClass = null;
                if (databaseProductName.toLowerCase().contains("h2")) {
                    dialectClass = H2Dialect.class;
                } else if (databaseProductName.toLowerCase().contains("postgresql")) {
                    dialectClass = PostgreSQL9Dialect.class;
                }
                if (dialectClass != null) {
                    properties.setProperty("hibernate.dialect", dialectClass.getCanonicalName());
                }
                if (System.getProperty(AvailableSettings.SHOW_SQL) != null) {
                    properties.setProperty(AvailableSettings.SHOW_SQL, System.getProperty(AvailableSettings.SHOW_SQL));
                }
                properties.setProperty(AvailableSettings.IMPLICIT_NAMING_STRATEGY, Hibernate4BasedNamingStrategy.class.getCanonicalName());
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                        log.warn("", e);
                    }
                }
            }
        } catch (Exception e) {
            log.warn("", e);
        }
        return properties;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
