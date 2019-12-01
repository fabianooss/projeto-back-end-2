package org.senac.projeto.controller;

import java.util.List;

import javax.validation.Valid;

import org.senac.projeto.domain.Area;
import org.senac.projeto.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
@CrossOrigin("*")
public class AreaController {
	
	@Autowired
	private AreaRepository repository;
	
	@PostMapping
	public void save(@RequestBody @Valid Area area) {
		repository.save(area);
	}
	
	@GetMapping
	public List<Area> findAll() {
		return repository.findAll();
	}

}
