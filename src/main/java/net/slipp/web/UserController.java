package net.slipp.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.slipp.model.User;

@Controller
public class UserController {

	private ArrayList<User> users = new ArrayList<>();
	
	@GetMapping("/users")
	public String list(Model model) {
		
		for(User userr : users) {
			System.out.println("list user : " + userr.toString());
		}
		model.addAttribute("users", users);
		
		return "/user/list";
	}
	
	
	@PostMapping("/user/create")
	public String create(User user) {
		
		users.add(user);
		
		for(User userr : users) {
			System.out.println("user : " + userr.toString());
		}
		
		return "redirect:/users";
	}
}
