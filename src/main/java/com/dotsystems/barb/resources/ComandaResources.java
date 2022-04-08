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

import com.dotsystems.barb.dtos.ComandaDTO;
import com.dotsystems.barb.services.ComandaService;

@Controller
@RequestMapping(value = "/comandas")
@CrossOrigin(origins = "*", maxAge = 36000)
public class ComandaResources {

	@Autowired
	private ComandaService service;

	@PostMapping
	public ResponseEntity<ComandaDTO> saveComanda(@RequestBody @Valid ComandaDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ComandaDTO> updateComanda(@PathVariable Long id, @RequestBody @Valid ComandaDTO obj) {
		ComandaDTO Comanda = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(Comanda);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deleteComanda(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<ComandaDTO>> findAll() {
		List<ComandaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ComandaDTO> findById(@PathVariable Long id) {
		ComandaDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
