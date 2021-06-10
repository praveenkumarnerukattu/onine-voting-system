package com.cg.society.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.society.entities.RegisteredSocietyVoters;
import com.cg.society.exceptions.RegisteredVoterNotFoundException;

@Service
public interface IRegisteredSocietyService {
	
	
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter);
	
	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter);
	
	 public void deleteRegisteredSocietyVoter(int voterId) throws RegisteredVoterNotFoundException;
	
	public List<RegisteredSocietyVoters> viewRegisteredVoterList();
	
	public RegisteredSocietyVoters searchByVoterID(int voterId) ;
	
	//public RegisteredSocietyVoters loginValidate(String userid,String password) ;
	
	public RegisteredSocietyVoters fetchById(int id) throws RegisteredVoterNotFoundException ;
	
	public List<RegisteredSocietyVoters> fetchAll();

	public RegisteredSocietyVoters addRegisteredSocietyVoters(RegisteredSocietyVoters registeredsociety);
	

}

