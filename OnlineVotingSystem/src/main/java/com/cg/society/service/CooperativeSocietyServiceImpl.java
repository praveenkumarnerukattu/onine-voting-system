package com.cg.society.service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.society.service.CooperativeSocietyServiceImpl;
import com.cg.society.repository.CooperativeSocietyRepository;
import com.cg.society.entities.CooperativeSociety;
import com.cg.society.exceptions.CooperativeSocietyNotFoundException;

@Service
public class CooperativeSocietyServiceImpl implements ICooperativeSocietyService {
	
	Logger logger = LoggerFactory.getLogger(CooperativeSocietyServiceImpl.class);
	
	@Autowired(required=true)
	private CooperativeSocietyRepository repository;// repository is a dependency of customerserviceimpl

	@Override
	public CooperativeSociety addCooperativeSociety(CooperativeSociety society) {
		logger.info("inside addCooperativeSocietydetails method of CooperativeServiceImpl");
		return repository.save(society);
	}
	
	@Override
	public List<CooperativeSociety> fetchAll() {
		return repository.findAll();
	}

	private void Logger(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public  CooperativeSociety updateSocietyDetails(CooperativeSociety cooperativesociety) {
	return repository.save(cooperativesociety);
	}
	



	@Override
	public CooperativeSociety deleteSociety(int societyId) throws CooperativeSocietyNotFoundException {
		Optional<CooperativeSociety> cooperativeSociety = repository.findById(societyId);
		if (!cooperativeSociety.isPresent())
			throw new CooperativeSocietyNotFoundException();
		return cooperativeSociety.get();
	}

	@Override
	public List<CooperativeSociety> viewSocietiesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CooperativeSociety viewSocietyById(int societyId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public CooperativeSociety  fetchById(int id) throws CooperativeSocietyNotFoundException{
		Optional<CooperativeSociety> cooperativeSociety = repository.findById(id);
		if (!cooperativeSociety.isPresent())
			throw new CooperativeSocietyNotFoundException();
		return cooperativeSociety.get();
		
	}

	

}
