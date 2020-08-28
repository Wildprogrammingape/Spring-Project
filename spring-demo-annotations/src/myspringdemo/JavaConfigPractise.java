package myspringdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("myspringdemo") 

public class JavaConfigPractise {
	
	//define bean for SumUp
	@Bean
	public SumUp mysumup() {
		return new HappySumUp();
	}
	
	
	// define bean for basketball coach and inject dependency
	@Bean
	public NewCoach mybasketballcoach() {   // method name is bean id
		
		return new BasketballCoach(mysumup());
	}
	
	

	
}
 