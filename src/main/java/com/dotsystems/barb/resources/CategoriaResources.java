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

import com.dotsystems.barb.dtos.CategoriaDTO;
import com.dotsystems.barb.services.CategoriaService;

@Controller
@RequestMapping(value = "/categorias")
@CrossOrigin(origins = "*", maxAge = 36000)
public class CategoriaResources {

	@Autowired
	private CategoriaService service;

	@PostMapping
	public ResponseEntity<CategoriaDTO> saveCategoria(@RequestBody @Valid CategoriaDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Long id, @RequestBody @Valid CategoriaDTO obj) {
		CategoriaDTO categoria = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deleteCategoria(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
		CategoriaDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
