package de.tkduha.tksfirst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tkduha.tksfirst.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{

}
