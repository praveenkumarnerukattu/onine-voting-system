package com.cg.society.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.cg.society.entities.CooperativeSociety;
import com.cg.society.exceptions.CooperativeSocietyNotFoundException;

@Service
public interface ICooperativeSocietyService {
	
	
	
	CooperativeSociety updateSocietyDetails(CooperativeSociety society);
	
	CooperativeSociety deleteSociety(int societyId) throws CooperativeSocietyNotFoundException ;
	
	List<CooperativeSociety> viewSocietiesList();
	
	CooperativeSociety viewSocietyById(int societyId) ;

	CooperativeSociety fetchById(int id) throws CooperativeSocietyNotFoundException;

	List<CooperativeSociety> fetchAll();

	CooperativeSociety addCooperativeSociety(@Valid CooperativeSociety cooperativesociety);

	

	 
}
