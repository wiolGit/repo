package com.example.projecta.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = {"classpath:application_database.properties"})
@EnableJpaRepositories(basePackages = "com.example.projecta.repository")
//@EnableTransactionManagement
@ComponentScan(basePackages="com.example.projecta.repository")
public class DatabaseConfiguration {

	
	
	@Value("${jdbc.driverClassName}")
	private String driverClass;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Bean
	public DataSource getDatasource()
	{
		
		DriverManagerDataSource datasource = new DriverManagerDataSource(url, username, password);
		datasource.setDriverClassName(driverClass);
		return datasource;
	
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
	
		properties.put("hibernate.naming-strategy", "hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
		properties.put("hibernate.naming.physical-strategy", "hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
	
		return properties;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDatasource());
		factory.setHibernateProperties(hibernateProperties());
		factory.setPackagesToScan(new String[] {"com.example.projecta.model"});
		return factory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory)
	{
		HibernateTransactionManager transactionManger = new HibernateTransactionManager();
		transactionManger.setSessionFactory(factory);
		return transactionManger;
		
	}
	/*
	@Bean
	public LocalContainerEntityManagerFactoryBean  entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(getDatasource());
		em.setPackagesToScan("");
		JpaVendorAdapter va = new HibrenateJpaVendorAdapter();
		em.setJpaVendorAdapter(va);
		em.setJpaProperties(hibernateProperties());
		
	}
*/
	
	 
}
