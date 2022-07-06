package com.dotsystems.barb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotsystems.barb.dtos.AgendamentoDTO;
import com.dotsystems.barb.services.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResources {

	@Autowired
	private AgendamentoService service;

	@PostMapping
	public ResponseEntity<AgendamentoDTO> save(@RequestBody AgendamentoDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@GetMapping
	public ResponseEntity<List<AgendamentoDTO>> findAll() {
		List<AgendamentoDTO> list = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AgendamentoDTO> findById(@PathVariable Long id) {
		AgendamentoDTO agend = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(agend);
	}
}
