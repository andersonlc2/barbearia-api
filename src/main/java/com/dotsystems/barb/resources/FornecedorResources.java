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

import com.dotsystems.barb.dtos.FornecedorDTO;
import com.dotsystems.barb.services.FornecedorService;

@Controller
@RequestMapping(value = "/fornecedores")
@CrossOrigin(origins = "*", maxAge = 36000)
public class FornecedorResources {

	@Autowired
	private FornecedorService service;

	@PostMapping
	public ResponseEntity<FornecedorDTO> saveFornecedor(@RequestBody @Valid FornecedorDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<FornecedorDTO> updateFornecedor(@PathVariable Long id,
			@RequestBody @Valid FornecedorDTO obj) {
		FornecedorDTO fornecedor = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(fornecedor);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deleteFornecedor(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<FornecedorDTO>> findAll() {
		List<FornecedorDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FornecedorDTO> findById(@PathVariable Long id) {
		FornecedorDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
