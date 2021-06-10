package com.cg.society.controller;

import java.util.List;

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
import com.cg.society.entities.RegisteredSocietyVoters;
import com.cg.society.exceptions.RegisteredVoterNotFoundException;
import com.cg.society.service.IRegisteredSocietyService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/RegisteredSocietyVoter")
public class RegisteredSocietyVoterController {
	
	
	Logger logger = LoggerFactory.getLogger(RegisteredSocietyVoterController.class);

	@Autowired
	private IRegisteredSocietyService service;// CustomerService is a dependency of CustomerContoller

	@GetMapping("/{name}")
	@ApiOperation("Greetings API")
	public String greetings(@PathVariable String name) {
		logger.info("Inside greetings!!");
		return "<h1>Welcome to Spring Boot " + name + "</h1>";
	}

	@PostMapping("/save")
	@ApiOperation("Add a RegisteredSocietyVoters Record")
	public ResponseEntity<RegisteredSocietyVoters> save(@Valid @RequestBody RegisteredSocietyVoters registeredsociety) {
		logger.info("Adding a Society Details!! ");
		RegisteredSocietyVoters registeredsociety1 = service.addRegisteredSocietyVoters(registeredsociety);
		return new ResponseEntity<>(registeredsociety1, HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("/getById/{id}")
	@ApiOperation("Get VoterRegistration ById")
	public RegisteredSocietyVoters fetchById(@PathVariable int id) throws NumberFormatException, RegisteredVoterNotFoundException {
		logger.info("Inside fetchById %s", id);
		return service.fetchById(id);
	}

	@GetMapping("/getAll")
	@ApiOperation("Fetch all RegisteredSocietyVoters Details")
	public List<RegisteredSocietyVoters> fetch() {
		logger.info("Fetching all RegisteredSocietyVoters records!!");
		return service.fetchAll();
	}
	
	@GetMapping("/SearchByVoterId/{voterId}")
	@ApiOperation("search  RegisteredSocietyVoters Details")
	public RegisteredSocietyVoters searchByVoterId(@PathVariable int voterId) throws NumberFormatException, RegisteredVoterNotFoundException {
	logger.info("Inside SearchByVoterId %s", voterId);
	return service.fetchById(voterId);
	}


	@PutMapping("/update")
	@ApiOperation("Update an Existing RegisteredSocietyVoters details")
	public void update(@Valid @RequestBody RegisteredSocietyVoters registeredsocietyvoters) {
		logger.info("Updating a RegisteredSocietyVoterDetails!!");
		service.updateRegisteredVoterDetails(registeredsocietyvoters);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete an Existing RegisteredSocietyVoters Record")
	public ResponseEntity<Void> delete(@PathVariable int id) throws RegisteredVoterNotFoundException {
		logger.info("Deleting a customer!!");
		service.deleteRegisteredSocietyVoter(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
