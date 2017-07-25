package com.expedia.events.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expedia.events.dto.Event;
import com.expedia.events.error.InputFieldDataNotValidException;

@RestController
@RequestMapping("/event/")
public class EventController {

	@GetMapping("/")
	public ResponseEntity<Event> getIndexEvent(Event event) {
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> createEvent(@Valid @RequestBody Event event, BindingResult result) {
		if (result.hasErrors()) {
			throw new InputFieldDataNotValidException(result);
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
