package de.tkduha.tksfirst.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

	@RequestMapping(method = RequestMethod.POST, path = "/animal")
	public String postAnimal() {
		return "<h2>Testrückgabe POST</h2>";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/animal")
	public String getAnimal() {
		return "<h2>Testrückgabe GET</h2>";
	}
	
}
