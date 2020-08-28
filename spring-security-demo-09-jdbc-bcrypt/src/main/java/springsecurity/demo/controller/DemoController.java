package springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	
	@GetMapping("/") // home page
	public String showHome() {
		
		return "home";
		
	}
	
	// add another request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
		
	}	
	
	// add another request mapping for /systems
	@GetMapping("/systems")
	public String showSystems() {
		
		return "systems";
		
	}	
}
