package in.project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@GetMapping("/hello")

	public String home(){
		return "hello";
	}
}
