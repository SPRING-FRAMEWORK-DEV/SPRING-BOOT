package com.java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.VehicleModel;
import com.java.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	VehicleService service;

	@RequestMapping("/")
	public String sayHello() {
		return "hello world";
	}

	@GetMapping(value = "vehicle-{id}")
	public ResponseEntity<VehicleModel> getvId(@PathVariable("id") int vId) {
		ResponseEntity<VehicleModel> response = new ResponseEntity<VehicleModel>(
				new VehicleModel(vId, "Car", "or123", "RK", "10-feb"),
				HttpStatus.OK);
		return response;

	}

	@PostMapping("vehicle-add")
	public ResponseEntity<String> addVehicle(@RequestBody VehicleModel model) {
		int id = service.addVehicle(model);
		ResponseEntity<String> response = new ResponseEntity<String>(
				"No of rows Added: " + id, HttpStatus.OK);
		return response;
	}

	@PostMapping("vehicle-update")
	public ResponseEntity<String> updateVehicle(@RequestBody VehicleModel model) {
		int id = service.updateVehicle(model);
		ResponseEntity<String> response = new ResponseEntity<String>(
				"No of row updated: " + id, HttpStatus.OK);
		return response;

	}

	@GetMapping("vehicle-delete-{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") int vId) {
		int id = service.deleteVehicle(vId);
		ResponseEntity<String> response = new ResponseEntity<String>(
				"No of rows deleted: " + id, HttpStatus.OK);
		return response;
	}

}
