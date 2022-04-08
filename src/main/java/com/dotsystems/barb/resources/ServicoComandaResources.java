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

import com.dotsystems.barb.dtos.ServicoComandaDTO;
import com.dotsystems.barb.services.ServicoComandaService;

@Controller
@RequestMapping(value = "/servicos_comanda")
@CrossOrigin(origins = "*", maxAge = 36000)
public class ServicoComandaResources {

	@Autowired
	private ServicoComandaService service;

	@PostMapping
	public ResponseEntity<ServicoComandaDTO> saveServicoComanda(@RequestBody @Valid ServicoComandaDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PostMapping(value = "/{id_comanda}")
	public ResponseEntity<ServicoComandaDTO> saveServicoComanda(@PathVariable Long id_comanda,
			@RequestBody @Valid ServicoComandaDTO obj) {
		service.save(id_comanda, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id_comanda}/{id}")
	public ResponseEntity<ServicoComandaDTO> updateServicoComanda(@PathVariable Long id_comanda, @PathVariable Long id,
			@RequestBody @Valid ServicoComandaDTO obj) {
		ServicoComandaDTO servicoComanda = service.update(id_comanda, id, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(servicoComanda);
	}

	@PutMapping(value = "/{id_comanda}")
	public ResponseEntity<ServicoComandaDTO> updateComanda(@PathVariable Long id_comanda,
			@RequestBody @Valid ServicoComandaDTO obj) {
		ServicoComandaDTO servicoComanda = service.update(id_comanda, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(servicoComanda);
	}

	@DeleteMapping(value = "/{id_comanda}/{id}")
	public ResponseEntity<Long> deleteServicoComanda(@PathVariable Long id_comanda, @PathVariable Long id) {
		service.delete(id_comanda, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<ServicoComandaDTO>> findAll() {
		List<ServicoComandaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<List<ServicoComandaDTO>> findByComanda(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findByComanda(id));
	}

	@GetMapping(value = "/{id}/{id_comanda}")
	public ResponseEntity<Object> findByServicoComanda(@PathVariable Long id, @PathVariable Long id_comanda) {
		return ResponseEntity.ok().body(service.findByServicoComanda(id, id_comanda));
	}
}
