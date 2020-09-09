package de.tkduha.tksfirst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tkduha.tksfirst.entities.Animal;
import de.tkduha.tksfirst.repositories.AnimalRepository;

@RestController
public class AnimalController {
	
	@Autowired
	AnimalRepository animalRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/animal", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Animal> getAnimals() {
		return animalRepository.findAll();
	}
	
}
