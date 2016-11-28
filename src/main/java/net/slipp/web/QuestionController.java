package net.slipp.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.model.Question;
import net.slipp.model.QuestionRepository;

@Controller
@RequestMapping("/questions")
public class QuestionController {

	private ArrayList<Question> questions = new ArrayList<>();
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/form")
	public String form() {
		return "/qna/form";
	}
	
	@GetMapping("")
	public String list(Model model) {
		
		model.addAttribute("questions", questionRepository.findAll());
		
		return "/qna/show";
	}
	
	
	@PostMapping("")
	public String create(Question question) {
		
		questions.add(question);
		
		questionRepository.save(question);
		
		
		return "redirect:/questions";
	}
}
