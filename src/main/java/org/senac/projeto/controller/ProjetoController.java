package org.senac.projeto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.senac.projeto.domain.Area;
import org.senac.projeto.domain.Projeto;
import org.senac.projeto.repository.AreaRepository;
import org.senac.projeto.repository.ProjetoRepository;
import org.senac.projeto.vo.AreaTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projeto")
@CrossOrigin("*")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository repository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Projeto projeto) {
		try {
			Optional<Area> area = 
					areaRepository.findById(projeto.getArea().getId());
			
			if (! area.isPresent()) {
				throw new Exception(
						String.format("Area %d não encontrada", 
								projeto.getArea().getId()));					
			}
			
			projeto.setArea(area.get());
			
			projeto.validarOrcamento();
			
			return ResponseEntity.ok( repository.save(projeto) );
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(
					e.getMessage());			
		}
		
	}
	
	@GetMapping
	public List<Projeto> findAll() {
		return repository.findAll(Sort.by("nome"));
	}
	
	@GetMapping("/{id:[0-9]}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		Optional<Projeto> projeto = repository.findById(id);
		if (projeto.isPresent()) {
			return ResponseEntity.ok(projeto.get());
		}
		return ResponseEntity.notFound().build();
	}

	
	@DeleteMapping("/{id}")	
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/total-area")
	public List<AreaTotal> findAreaTotal() {
		return repository.findAreaTotal();
	}
}
