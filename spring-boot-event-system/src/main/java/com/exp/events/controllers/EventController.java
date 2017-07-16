package com.exp.events.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exp.events.bo.Event;
import com.exp.events.bo.Location;
import com.exp.events.dto.EventRepresentation;
import com.exp.events.services.EventGeoService;

@Controller
@RequestMapping("/event/")
public class EventController {

	@Autowired
	private EventGeoService eventGeoService;

	@GetMapping("/")
	@ResponseBody
	public EventRepresentation getIndex(EventRepresentation event) {

		event = new EventRepresentation("e1", "ep1", "ea", new Location(32.24f, 34.56f));
		return event	;
	}

	@PostMapping("/create")
	@ResponseBody
	public void postCreateEvent(@RequestBody EventRepresentation eventRepresentation) {
		eventGeoService.createEvent(eventRepresentation);
	}

	@GetMapping("/list")
	@ResponseBody
	public List<Event> getAllEvent() {

		return eventGeoService.findAll();
	}

	@GetMapping("/by-distance-lat-{longitude}-lang-{latitude}-position")
	@ResponseBody
	public List<Event> getAllEventsByDistance(@PathVariable("longitude") Double longitude,
			@PathVariable("latitude") Double latitude, @RequestParam("distance") Float distance) {

		return eventGeoService.findByDistance(longitude, latitude, distance);
	}

}
