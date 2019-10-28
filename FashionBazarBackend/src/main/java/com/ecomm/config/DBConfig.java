package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
import com.ecomm.model.UserDetail;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")
@EnableWebMvc
public class DBConfig 
{

	//Create a Data Source Bean
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		System.out.println("---DataSource object is Created");
		return dataSource;
	}
	
	
	//Create a SessionFactory Bean
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		//Creating a LocalSessionFactoryBuilder object and this constructor will take an object
		//of DataSource hence we are passing the method getH2DataSource()
		//This class is used for creating the SessionFactory object.
		DataSource dataSource=this.getH2DataSource();
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(dataSource);
		factory.addProperties(properties);
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Supplier.class);
		
		System.out.println("---Session Factory Object is crated---");
		SessionFactory sessionFactory=factory.buildSessionFactory();
		return sessionFactory;
	}
	
	//Create a HibernateTransaction Bean
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager Object is Created ---");
		return new HibernateTransactionManager(sessionFactory);
	}
	
}
