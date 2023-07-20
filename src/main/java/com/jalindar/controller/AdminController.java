package com.jalindar.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jalindar.model.UserDtls;
import com.jalindar.repository.UserRepository;
//import com.jalindar.repository.UsercrudRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserRepository usercrudRepo;
	@GetMapping("/")
	public String home() {
		return "admin/index";
	}
	@GetMapping("/load_form")
	public String loadForm() {
		return "admin/add";
	}
	@GetMapping("/edit_form")
	public String editForm() {
		return "admin/edit";
	}
	@PostMapping("/save_users")
	public String saveUsers(@ModelAttribute UserDtls users,HttpSession session) {
		usercrudRepo.save(users);
		session.setAttribute("msg","Used added succesfully");
		
	return "redirect:/admin/load_form";
	}

}
