package net.slipp.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.slipp.model.Question;

@Controller
public class QuestionController {

	private ArrayList<Question> questions = new ArrayList<>();
	
	@GetMapping("/questions")
	public String list(Model model) {
		
		for(Question question1 : questions) {
			System.out.println("list qna : " + question1.toString());
		}
		model.addAttribute("questions", questions);
		
		return "/qna/show";
	}
	
	
	@PostMapping("/qna/create")
	public String create(Question question) {
		
		questions.add(question);
		
		for(Question question1 : questions) {
			System.out.println("qna : " + question1.toString());
		}
		
		return "redirect:/questions";
	}
}
