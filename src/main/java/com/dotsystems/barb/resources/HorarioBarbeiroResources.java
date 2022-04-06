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

import com.dotsystems.barb.dtos.HorarioBarbeiroDTO;
import com.dotsystems.barb.services.HorarioBarbeiroService;

@Controller
@RequestMapping(value = "/horario_barbeiros")
@CrossOrigin(origins = "*", maxAge = 36000)
public class HorarioBarbeiroResources {

	@Autowired
	private HorarioBarbeiroService service;

	@PostMapping
	public ResponseEntity<HorarioBarbeiroDTO> saveHorarioBarbeiro(@RequestBody @Valid HorarioBarbeiroDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id}/{id_horario}")
	public ResponseEntity<HorarioBarbeiroDTO> updateHorarioBarbeiro(@PathVariable Long id, @PathVariable Long id_horario, 
			@RequestBody @Valid HorarioBarbeiroDTO obj) {
		HorarioBarbeiroDTO horarioBarbeiro = service.update(id, id_horario, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(horarioBarbeiro);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deleteHorarioBarbeiro(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<HorarioBarbeiroDTO>> findAll() {
		List<HorarioBarbeiroDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<List<HorarioBarbeiroDTO>> findByBarbeiro(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findByBarbeiro(id));
	}

	@GetMapping(value = "/{id}/{id_horario}")
	public ResponseEntity<Object> findByBarbeiroHorario(@PathVariable Long id, @PathVariable Long id_horario) {
		return ResponseEntity.ok().body(service.findByBarbeiroHorario(id, id_horario));
	}
}
