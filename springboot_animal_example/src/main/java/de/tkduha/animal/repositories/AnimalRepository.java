package de.tkduha.animal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tkduha.animal.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	public List<Animal> findAllByOrderByIdAsc();
}
