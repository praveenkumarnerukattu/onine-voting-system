package com.cg.society.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.society.entities.RegisteredSocietyVoters;
import com.cg.society.exceptions.RegisteredVoterNotFoundException;
import com.cg.society.repository.RegisteredSocietyVotersRepository;


@Service
public class RegisteredSocietyVotersServiceImpl implements IRegisteredSocietyService {

	Logger logger = LoggerFactory.getLogger(RegisteredSocietyVotersServiceImpl.class);
	
	@Autowired//(required=true)
	private RegisteredSocietyVotersRepository repository; // repository is a dependency of RegisteredSocietyVotersServiceImpl 
	
	@Override
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter) {
		// TODO Auto-generated method stub
		logger.info("Inside addVoterRegistration method of RegisteredSocietyVotersServiceImpl");
		return repository.save(voter);
	}

	@Override
	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter) {
		// TODO Auto-generated method stub
		return repository.save(voter);
	}

	@Override
	public void  deleteRegisteredSocietyVoter(int voterId) throws RegisteredVoterNotFoundException {
		// TODO Auto-generated method stub
		Optional<RegisteredSocietyVoters> registeredsocietyvoters = repository.findByVoterId(voterId);
		if(!registeredsocietyvoters.isPresent()) throw new RegisteredVoterNotFoundException();
		repository.deleteById(voterId);
	}

	@Override
	public List<RegisteredSocietyVoters> viewRegisteredVoterList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisteredSocietyVoters searchByVoterID(int voterId) {
		// TODO Auto-generated method stub
		return repository.searchByVoterId(voterId);
		
	}

	/*@Override
	public RegisteredSocietyVoters loginValidate(String userid, String password) {
		// TODO Auto-generated method stub
		
		return null;
	}*/

	@Override
	public RegisteredSocietyVoters fetchById(int voterId) throws RegisteredVoterNotFoundException {
		// TODO Auto-generated method stub
		Optional<RegisteredSocietyVoters> registeredsocietyvoters = repository.findById(voterId);
		if (!registeredsocietyvoters.isPresent())
			throw new RegisteredVoterNotFoundException();

		return registeredsocietyvoters.get();
	}

	@Override
	public List<RegisteredSocietyVoters> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisteredSocietyVoters addRegisteredSocietyVoters(RegisteredSocietyVoters registeredsociety) {
		// TODO Auto-generated method stub
		logger.info("inside addCustomer method of CustomerServiceImpl");
		return repository.save(registeredsociety);
	
		
	}

	

}
