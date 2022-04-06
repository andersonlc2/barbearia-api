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

import com.dotsystems.barb.dtos.BarbeiroDTO;
import com.dotsystems.barb.dtos.BarbeiroInsertDTO;
import com.dotsystems.barb.services.BarbeiroService;

@Controller
@RequestMapping(value = "/barbeiros")
@CrossOrigin(origins = "*", maxAge = 36000)
public class BarbeiroResources {

	@Autowired
	private BarbeiroService service;

	@PostMapping
	public ResponseEntity<BarbeiroInsertDTO> saveBarbeiro(@RequestBody @Valid BarbeiroInsertDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<BarbeiroInsertDTO> updateBarbeiro(@PathVariable Long id,
			@RequestBody @Valid BarbeiroInsertDTO obj) {
		BarbeiroInsertDTO barbeiro = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(barbeiro);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deleteBarbeiro(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<BarbeiroDTO>> findAll() {
		List<BarbeiroDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<BarbeiroDTO> findById(@PathVariable Long id) {
		BarbeiroDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
