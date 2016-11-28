package net.slipp.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.model.User;
import net.slipp.model.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "/user/profile";
	}
	
	
	
	
	
	@GetMapping("/form")
	public String form() {
		return "/user/form";
	}
	
	@GetMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, Model model) {
		System.out.println(id);
		model.addAttribute("user", userRepository.findOne(id));
		
		return "/user/updateForm";
	}
	
	@GetMapping("")
	public String list(Model model) {
		
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	
	@PostMapping("")
	public String create(User user) {
		
		userRepository.save(user);
		
		return "redirect:/users";
	}
	
	@PostMapping("/{id}/update")
	public String update(@PathVariable Long id, User user) {
		
		userRepository.save(user);
		
		return "redirect:/users";
	}
}
