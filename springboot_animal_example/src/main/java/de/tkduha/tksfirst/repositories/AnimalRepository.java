package de.tkduha.tksfirst.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tkduha.tksfirst.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	public List<Animal> findAllByOrderByIdAsc();
}
