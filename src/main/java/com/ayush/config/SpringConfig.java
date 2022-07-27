package com.ayush.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ayush.model.Employee;

@Configuration
@ComponentScan({ "com.ayush" })
public class SpringConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();

//		get all the view templates from views folder
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");

		return vr;
	}


	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		sessionFactory.setAnnotatedClasses(Employee.class);
		
		return sessionFactory;
	}
	
	
	
	
//	SET DATA SOURCE POPERTIES
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3308/emp_mvc_rest?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	}
//	@Bean
//	public DataSource dataSource() {
//		BasicDataSource dataSource =  new BasicDataSource();
//		
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3308/emp_mvc_rest?useSSL=false");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		
//		return  dataSource;
//	}
	
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
	}
	
//	TEMPLATE SET FOR HIBERNATE
	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate template = new HibernateTemplate();
		
		template.setSessionFactory(sessionFactory().getObject());
		
		return template;
	}
	
//	HIBERNATE PROPERTIES
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return hibernateProperties;
	}
	
}
