package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@GetMapping("/private")
	@ResponseBody
	public String getPrivateData() {
		return "private-data";
	}

	@GetMapping("/")
	@ResponseBody
	public String getIndex() {
		return "index";
	}
}
