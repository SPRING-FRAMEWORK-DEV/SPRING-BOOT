package com.java.forms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.forms.model.Post;
import com.java.forms.model.User;
import com.java.forms.utils.ErrorMapper;
import com.java.forms.utils.UserManager;

@Controller
public class DemoController {

	@Autowired
	UserManager manager;

	@GetMapping(value = "/")
	public String index(Post post) {
		return "forms/home";
	}

	@PostMapping(value = "/")
	public String addNewPost(@Valid Post post, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "forms/home";
		}
		model.addAttribute("title", post.getTitle());
		model.addAttribute("content", post.getContent());
		return "forms/result";
	}

	@GetMapping(value = "/ajaxFormValidation1")
	public String ajaxFormValidation1() {
		return "forms/ajax-form-validation1";
	}

	@PostMapping(value = "/ajaxFormValidation1")
	public ResponseEntity<String> addNewPost1(@Valid User user, BindingResult bindingResult, Model model)
			throws JsonProcessingException {

		ResponseEntity<String> response = null;
		System.out.println(bindingResult.getFieldErrors());
		if (bindingResult.hasErrors()) {

			response = new ResponseEntity<String>(
					"ERROR:" + ErrorMapper.getErrorFieldMessages(bindingResult.getFieldErrors()), HttpStatus.OK);
			return response;
		}

		response = new ResponseEntity<String>(user.toString(), HttpStatus.OK);
		return response;
	}

	@GetMapping(value = "/display-user-list")
	public String userList(Model model) {

		model.addAttribute("users", manager.fetchAll());
		return "forms/user-list";
	}

	@GetMapping(value = "/view-user-{id}")
	public String userList(@PathVariable("id") int userId, Model model) {

		model.addAttribute("users", manager.getById(userId));
		return "forms/user";
	}
}
