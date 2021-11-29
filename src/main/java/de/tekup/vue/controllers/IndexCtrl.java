package de.tekup.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.tekup.vue.ui.models.WelcomeMsg;

@Controller
public class IndexCtrl {
	
	@GetMapping({"/","/index"})
	public String getIndex(Model model) {
		WelcomeMsg welcome = new WelcomeMsg("Welcome GLSI-C", "First Vue Project");
		model.addAttribute("welcome", welcome);
		return "index";
	}
	
	@GetMapping("/add/user")
	public String getInnerPage() {
		return "inner/inner-page";
	}

}
