package springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {            // from "DemoSecurityConfig.java"
		
		return "fancy-login";
	}
	
	
	// add request mapping for /access-denied
	@GetMapping("/access-denied") 				 // from "DemoSecurityConfig.java"
	public String showAccessDenied() {
		
		return "access-denied";
	}	
	
	
}
