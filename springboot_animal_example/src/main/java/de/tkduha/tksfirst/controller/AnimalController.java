package de.tkduha.tksfirst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tkduha.tksfirst.entities.Animal;
import de.tkduha.tksfirst.repositories.AnimalRepository;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	AnimalRepository animalRepository;
	
	@GetMapping
	public List<Animal> getAllAnimals() {
		return animalRepository.findAllByOrderByIdAsc();
	}
	
	@PostMapping
	public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
		if(animalRepository.existsById(animal.getId())) {
			return new ResponseEntity<Animal>(animalRepository.findById(animal.getId()).get(), HttpStatus.METHOD_NOT_ALLOWED);
		}
		animalRepository.save(animal);
		return new ResponseEntity<Animal>(animal, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Animal> modifyAnimal(@RequestBody Animal animal) {
		if(!animalRepository.existsById(animal.getId())) {
			return new ResponseEntity<Animal>(animal, HttpStatus.NOT_FOUND);
		}
		animalRepository.save(animal);
		return new ResponseEntity<Animal>(animal, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Animal> deleteAnimal(@RequestBody Animal animal) {
		if(!animalRepository.existsById(animal.getId())) {
			return new ResponseEntity<Animal>(animal, HttpStatus.NOT_FOUND);
		}
		animalRepository.deleteById(animal.getId());
		return new ResponseEntity<Animal>(animal, HttpStatus.OK);
	}
}
