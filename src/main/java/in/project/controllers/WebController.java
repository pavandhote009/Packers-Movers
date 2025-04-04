package in.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	 @RequestMapping(value = { "/", "/{path:[^\\.]*}" })
	    public String forwardToReact() {
	        return "forward:/index.html";
	    }
}
