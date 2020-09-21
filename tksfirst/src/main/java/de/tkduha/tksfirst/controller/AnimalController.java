package de.tkduha.tksfirst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tkduha.tksfirst.entities.Animal;
import de.tkduha.tksfirst.repositories.AnimalRepository;

@RestController
public class AnimalController {
	
	@Autowired
	AnimalRepository animalRepository;
	
	@GetMapping("/animal")
	public List<Animal> getAllAnimals() {
		return animalRepository.findAll();
	}
	
	@PostMapping("/animal")
	public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
		if(animalRepository.existsById(animal.getId())) {
			return new ResponseEntity<Animal>(animalRepository.getOne(animal.getId()), HttpStatus.METHOD_NOT_ALLOWED);
		}
		return new ResponseEntity<Animal>(animal, HttpStatus.CREATED);
	}
	
}
