package com.dotsystems.barb.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dotsystems.barb.dtos.EquipeDTO;
import com.dotsystems.barb.services.EquipeService;

@Controller
@RequestMapping(value = "/equipes")
@CrossOrigin(origins = "*", maxAge = 36000)
public class EquipeResources {

	@Autowired
	private EquipeService service;

	@PostMapping
	public ResponseEntity<EquipeDTO> saveEquipe(@RequestBody @Valid EquipeDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipeDTO> updateEquipe(@PathVariable Long id, @RequestBody @Valid EquipeDTO obj) {
		EquipeDTO Equipe = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(Equipe);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deleteEquipe(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<EquipeDTO>> findAll() {
		List<EquipeDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EquipeDTO> findById(@PathVariable Long id) {
		EquipeDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
