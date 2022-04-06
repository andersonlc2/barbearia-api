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

import com.dotsystems.barb.dtos.HorarioDTO;
import com.dotsystems.barb.services.HorarioService;

@Controller
@RequestMapping(value = "/horarios")
@CrossOrigin(origins = "*", maxAge = 36000)
public class HorarioResources {

	@Autowired
	private HorarioService service;

	@PostMapping
	public ResponseEntity<HorarioDTO> saveHorario(@RequestBody @Valid HorarioDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<HorarioDTO> updateHorario(@PathVariable Long id, @RequestBody @Valid HorarioDTO obj) {
		HorarioDTO Horario = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(Horario);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deleteHorario(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<HorarioDTO>> findAll() {
		List<HorarioDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<HorarioDTO> findById(@PathVariable Long id) {
		HorarioDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
