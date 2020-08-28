package springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration										 // this is a configuration class
@EnableWebMvc									     // provide similar support to <mvc:annotation-driven>
@ComponentScan(basePackages="springsecurity.demo")   // where to scan for controller, service and other support class
public class DemoAppConfig {

	
	
	// define a bean for viewResolver
	// in order to map "/WEB-INF/view/show-student-list.jsp"
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
}
