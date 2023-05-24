package org.lesson.java.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String printFirstString(Model model,
			@RequestParam(name = "name") String name) {
		model.addAttribute("name", name);
		
		return "index";
	}
}
