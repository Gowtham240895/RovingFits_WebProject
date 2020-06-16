package com.niit.RovingFits.Config;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.niit")
@EnableTransactionManagement
public class DBConfig {
	@Bean
	public BasicDataSource myDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("org.h2.Driver");
		basicDataSource.setUrl("jdbc:h2:~/RovingFits");
		basicDataSource.setUsername("sa");
		basicDataSource.setPassword("password");
		System.out.println("Message from sessionfactory");
		return basicDataSource;
	}

	Properties myDBProperties() {
		Properties properties = new Properties();
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
		properties.setProperty(Environment.HBM2DDL_AUTO, "update");
		properties.setProperty(Environment.SHOW_SQL, "true");
		System.out.println("Message from sessionfactory");
		return properties;
	}

	@Bean(name = "sessionfactory")
	LocalSessionFactoryBean mySessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(myDataSource());
		localSessionFactoryBean.setHibernateProperties(myDBProperties());
		// localSessionFactoryBean.setAnnotatedClasses(annotatedClasses); in case i have
		// only class

		// now i have to say which classes should i uses to create tables
		localSessionFactoryBean.setPackagesToScan("com.niit.RovingFits.Model");
		System.out.println("Message from sessionfactory");
		return localSessionFactoryBean;
	}

	@Autowired
	@Bean
	HibernateTransactionManager enableTransanction(SessionFactory sessionfactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionfactory);
		return hibernateTransactionManager;
	}

}
