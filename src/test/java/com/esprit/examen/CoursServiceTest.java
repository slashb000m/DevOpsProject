package com.esprit.examen;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;

import junit.framework.Assert;

@SpringBootTest
public class CoursServiceTest {
	
	@Autowired
	CoursRepository coursRepository;
	
	//@Test
	public void testAddCours(){
		// 
		Cours cours = new Cours();
		cours.setDescription("Cours Dev ops");
		cours.setIntitule("DEVOPS Course");
		cours.setTypeCours(TypeCours.Informatique);
		coursRepository.save(cours);
		Optional<Cours> insertedCours = coursRepository.findById(Long.valueOf(1));
		Assert.assertEquals(true, insertedCours.isPresent());
		coursRepository.delete(cours);
		
	}
	
	

}
