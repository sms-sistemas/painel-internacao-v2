package com.crud.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crud.app.model.User;

@Controller
public class UserContorller {

	List<User> luser = new ArrayList<>();

	@GetMapping("/create")
	public String home() {
		return "create";
	}

	@PostMapping("/create")
	public String create(User user) {
		Long id = luser.size() + 1L;
		luser.add(new User(id, user.getNome(), user.getEmail(), user.getSenha()));

		return "redirect:/list";
	}

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("list");

		mv.addObject("luser", luser);

		return mv;
	}

}
