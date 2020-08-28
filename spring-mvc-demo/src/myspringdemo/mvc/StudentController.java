package myspringdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")     // parent mapping

public class StudentController {
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent);
							  // name       value
		//(将类型为Student的object theStudent添加到Model仓库中，id为“student”)
		
		return "student-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
							//  bind ModelAttribute to the parameter passed in
		
		// load the input date
		System.out.println("theStudent: "+ theStudent.getFirstName()
		+ " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
}




