package com.esprit.examen;

import java.util.Optional;

import com.esprit.examen.services.ICoursService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;

import junit.framework.Assert;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
public class CoursServiceTest {
	
	@Autowired
	CoursRepository coursRepository;
	@Autowired
	ICoursService courService;

	@Test
	public void testAddCours(){
		Cours cours = new Cours();
		cours.setDescription("Cours Dev ops");
		cours.setIntitule("DEVOPS Course");
		cours.setTypeCours(TypeCours.Informatique);
		courService.addCours(cours);
		boolean res= courService.getCours().stream().anyMatch(curs-> curs.toString().equals(cours.toString()));
		assertTrue(res);
		courService.supprimerCours(cours.getId());
	}
	@Test
	public void testUpdateCourse(){
		Cours cours = new Cours(1L,"testing",TypeCours.Informatique,"test");
		Cours updateCours = new Cours(1L,"testing",TypeCours.Informatique,"testingUpdate");
		 Cours updateCoursFinal = courService.updateCoursById(cours.getId(),updateCours);
		assertEquals("testingUpdate",updateCoursFinal.getIntitule());

	}
	@Test
	public void TestDeleteCours(){
		Cours cours = new Cours();
		cours.setDescription("Cours Dev ops");
		cours.setIntitule("DEVOPS Course");
		cours.setTypeCours(TypeCours.Informatique);
		courService.addCours(cours);
		courService.supprimerCours(cours.getId());
		boolean res= courService.getCours().stream().anyMatch(curs-> curs.toString().equals(cours.toString()));
		assertFalse(res);
	}
}
