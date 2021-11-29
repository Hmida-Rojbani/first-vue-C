package de.tekup.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.vue.repos.UserDB;
import de.tekup.vue.ui.models.User;
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
	public String getInnerPage(Model model) {
		model.addAttribute("user", new User());
		return "inner/add-user";
	}
	
	@PostMapping("/add/user")
	public String postInnerPage(@ModelAttribute("user") User user) {
		System.out.println(user);
		//save to DB
		UserDB.addUser(user);
		System.out.println(UserDB.getUsers());
		return "redirect:/show/users";
	}

	@GetMapping("/show/users")
	public String getShowUsers(Model model) {
		model.addAttribute("listUsers", UserDB.getUsers());
		return "inner/show-users";
	}
	
	@GetMapping("/delete/user/{id}")
	public String getShowUsers(@PathVariable int id) {
		UserDB.deleteUser(id);
		return "redirect:/show/users";
	}
	
	@GetMapping("/update/user/{id}")
	public String updateUser(@PathVariable int id, Model model) {
		model.addAttribute("user", UserDB.getUser(id));
		return "inner/add-user";
	}
}
