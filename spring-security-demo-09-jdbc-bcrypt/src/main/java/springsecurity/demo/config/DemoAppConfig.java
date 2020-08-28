package springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration										 // this is a configuration class
@EnableWebMvc									     // provide similar support to <mvc:annotation-driven>
@ComponentScan(basePackages="springsecurity.demo")   // where to scan for controller, service and other support class
@PropertySource("classpath:persistence-mysql.properties") // read the properties file (src/main/resource)
public class DemoAppConfig {

	// set up variable to hold the properties
	
	@Autowired
	private Environment env;  // environment is spring helper class to read data from properties files
	
	// set up a logger for diagnostics
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	// define a bean for viewResolver
	// in order to map "/WEB-INF/view/show-student-list.jsp"
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// define a bean for our security databse
	
	@Bean
	public DataSource securityDataSource() {
		
		// crate connection pool
		ComboPooledDataSource securityDataSource
												= new ComboPooledDataSource();
		
		
		// set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
			
		}
		
		
		
		// log the connection properties
		logger.info(">>>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>>> jdbc.url=" + env.getProperty("jdbc.user"));
		
		
		
		// set database connection properties
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool properties
		
		securityDataSource.setInitialPoolSize(
				   getIntProperty("connection.pool.initialPoolSize"));
		
		securityDataSource.setMinPoolSize(
				   getIntProperty("connection.pool.minPoolSize"));
		
		securityDataSource.setMaxPoolSize(
				   getIntProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setMaxIdleTime(
				   getIntProperty("connection.pool.maxIdleTime"));
		
		
		
		return securityDataSource;
		
		
	}
	
	
	// need a helper method, read environment property and convert to int
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		// now convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
		
	}
	
	
	
	
	
}
