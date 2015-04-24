package com.hackathon;

import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class PersistenceConfig {

	@Bean
	BasicDataSource dataSource() throws URISyntaxException {

		String dbString = "jdbc:mysql://hackdb.c4edy7boveqz.us-west-2.rds.amazonaws.com:3306/productdb";

		BasicDataSource result = new BasicDataSource();
		result.setUrl(dbString);
		result.setUsername("admin");
		result.setPassword("password");
		result.setDriverClassName("com.mysql.jdbc.Driver");
		
		result.setMaxActive(10);
		
		System.out.println("this worked");
		
		return result;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		jpaProperties.put("hibernate.show_sql", "true");
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		entityManagerFactory.setJpaProperties(jpaProperties);
		return entityManagerFactory;
	}

	@Bean
	JpaTransactionManager transactionManager() throws URISyntaxException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getNativeEntityManagerFactory());
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
}
