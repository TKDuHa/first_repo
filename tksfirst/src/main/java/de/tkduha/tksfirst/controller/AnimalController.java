package de.tkduha.tksfirst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tkduha.tksfirst.entities.Animal;
import de.tkduha.tksfirst.repositories.AnimalRepository;

@RestController
public class AnimalController {
	
	@Autowired
	AnimalRepository animalRepository;
	
	@GetMapping("/animal")
	public List<Animal> getAnimals() {
		return animalRepository.findAll();
	}
	
	@PutMapping("/animal/{id}")
	public void setAnimalsRace(@PathVariable Integer id, @RequestParam(name = "race") String race) {
		Animal animal = animalRepository.getOne(id);
		animal.setRace(race);
		animalRepository.save(animal);
	}
	
}
