package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubmissionController {
	@Autowired
	private SubmitRepository submissionRepository;
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("submission" , new Submission());
		return "form";
	}
	@PostMapping("/submit")
	public String submitForm(@ModelAttribute Submission submission , Model model) {
		submissionRepository.save(submission);
		model.addAttribute("submission");
		return "result";
	}
}
