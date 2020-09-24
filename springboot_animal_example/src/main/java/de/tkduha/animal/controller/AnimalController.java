package de.tkduha.animal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tkduha.animal.entities.Animal;
import de.tkduha.animal.repositories.AnimalRepository;

@RestController
@RequestMapping("/animal")
@CrossOrigin
public class AnimalController {
	
	@Autowired
	AnimalRepository animalRepository;
	
	@GetMapping
	public List<Animal> getAllAnimals() {
		return animalRepository.findAllByOrderByIdAsc();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Animal> getAnimalById(@PathVariable int id) {
		Optional<Animal> animal = animalRepository.findById(id);
		if(animal.isPresent()) {
			return new ResponseEntity<Animal>(animal.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
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
