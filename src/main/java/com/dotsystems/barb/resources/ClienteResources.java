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

import com.dotsystems.barb.dtos.ClienteDTO;
import com.dotsystems.barb.dtos.ClienteInsertDTO;
import com.dotsystems.barb.services.ClienteService;

@Controller
@RequestMapping(value = "/clientes")
@CrossOrigin(origins = "*", maxAge = 36000)
public class ClienteResources {

	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<ClienteInsertDTO> saveCliente(@RequestBody @Valid ClienteInsertDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteInsertDTO> updateCliente(@PathVariable Long id,
			@RequestBody @Valid ClienteInsertDTO obj) {
		ClienteInsertDTO cliente = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deleteCliente(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<ClienteDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
		ClienteDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
