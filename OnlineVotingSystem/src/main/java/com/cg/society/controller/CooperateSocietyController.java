package com.cg.society.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.society.entities.CooperativeSociety;
import com.cg.society.exceptions.CooperativeSocietyNotFoundException;
import com.cg.society.controller.CooperateSocietyController;
import com.cg.society.service.ICooperativeSocietyService;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/CooperativeSociety")
public class CooperateSocietyController {
	
	
	Logger logger = LoggerFactory.getLogger(CooperateSocietyController.class);

	@SuppressWarnings("unused")
	@Autowired
	private ICooperativeSocietyService service; // CooperativeSocietyService is a dependency of CooperateSocietyController 

	@GetMapping("/{name}")
	@ApiOperation("Greetings API")
	public String greetings(@PathVariable String name) {
		logger.info("Inside greetings!!");
		return "<h1>Welcome to Spring Boot " + name + "</h1>";
	}
	
	@GetMapping("/getById/{Id}")
	@ApiOperation("Add Society Details ")
	public CooperativeSociety fetchById(@PathVariable int id) throws NumberFormatException, CooperativeSocietyNotFoundException {
		logger.info("Inside fetchById %s", id);
		return service.fetchById(id);
	}
	
	
	
	@PostMapping("/save")
	@ApiOperation("Add a CooperativeSociety Record")
	public ResponseEntity<CooperativeSociety> save(@Valid @RequestBody CooperativeSociety cooperativesociety) {
		logger.info("Adding a Society Details!! ");
		CooperativeSociety society = service.addCooperativeSociety(cooperativesociety);
		return new ResponseEntity<>(society, HttpStatus.CREATED);
	}
	@PutMapping("/update")
	@ApiOperation("Update Society Details")
	public void update(@Valid @RequestBody  CooperativeSociety cooperativesociety) {
		logger.info("Updating a Society Details!!");
		service.updateSocietyDetails(cooperativesociety);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete an Existing Cooperate Society Member Details")
	public ResponseEntity<Void> delete(@PathVariable int id) throws CooperativeSocietyNotFoundException {
		logger.info("Deleting a customer!!");
		service.deleteSociety(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
