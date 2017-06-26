package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.User;
import com.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/")
	public String getIndex() {
		return "redirect:/add-user";
	}

	@GetMapping("/load")
	@ResponseBody
	public String loadData() {
		service.addAll();
		return "inserted";
	}

	@GetMapping("/view-all")
	@ResponseBody
	public List<User> getAllUser() {
		return service.getAll();
	}

	@GetMapping("/find-one-{userId}")
	@ResponseBody
	public User getUserById(@PathVariable("userId") String userId) {
		return service.getById(userId);
	}

	@PostMapping("/add-user")
	public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "home";
		}
		service.save(user);
		return "success";
	}

	@GetMapping(value = "/add-user")
	public String index(Model model) {
		model.addAttribute("user", new User());
		return "home";
	}

	@GetMapping("/delete-user-{id}")
	@ResponseBody
	public String delete(@PathVariable("id") String userId) {
		service.deleteById(userId);
		return "deleted";
	}

}
