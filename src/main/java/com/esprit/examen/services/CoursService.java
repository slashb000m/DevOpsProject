package com.esprit.examen.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CoursService implements ICoursService {

	@Autowired
	CoursRepository coursRepository;
	@Override
	public Long addCours(Cours cours) {
		coursRepository.save(cours);
		log.info("added course "+ cours);
		return cours.getId();
	}

	@Override
	public Long modifierCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
		}

	@Override
	public void supprimerCours(Long coursId) {
		coursRepository.deleteById(coursId);
		
	}

	@Override
	public List<Cours> getCours() {
		
		List<Cours> cours =   coursRepository.findAll();
		return cours;
	}
	
	@Override
	public void affecterCoursASession(Long coursId, Long sessionId)
	{
		/*todo*/
        
	}

	@Override
	public Cours updateCoursById(long coursId, Cours cours) {
		Cours cours1= new Cours(cours.getId(),cours.getDescription(),cours.getTypeCours(),cours.getIntitule());
		cours1.setTypeCours(cours.getTypeCours());
		cours1.setDescription(cours.getDescription());
		cours1.setIntitule(cours.getIntitule());
		log.info("cours update sucess", cours1.getId());
		return cours1;
	}
}
