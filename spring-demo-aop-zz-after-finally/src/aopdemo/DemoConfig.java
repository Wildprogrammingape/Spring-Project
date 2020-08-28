package aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration            // spring pure java configuration	
@EnableAspectJAutoProxy   // spring aop proxy support
@ComponentScan("aopdemo") // component scan for components and aspects -- resource packages
public class DemoConfig {

}
