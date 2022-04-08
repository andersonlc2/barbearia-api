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

import com.dotsystems.barb.dtos.ProdutoComandaDTO;
import com.dotsystems.barb.services.ProdutoComandaService;

@Controller
@RequestMapping(value = "/produtos_comanda")
@CrossOrigin(origins = "*", maxAge = 36000)
public class ProdutoComandaResources {

	@Autowired
	private ProdutoComandaService service;

	@PostMapping
	public ResponseEntity<ProdutoComandaDTO> saveProdutoComanda(@RequestBody @Valid ProdutoComandaDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PostMapping(value = "/{id_comanda}")
	public ResponseEntity<ProdutoComandaDTO> saveProdutoComanda(@PathVariable Long id_comanda,
			@RequestBody @Valid ProdutoComandaDTO obj) {
		service.save(id_comanda, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id_comanda}/{id}")
	public ResponseEntity<ProdutoComandaDTO> updateProdutoComanda(@PathVariable Long id_comanda, @PathVariable Long id,
			@RequestBody @Valid ProdutoComandaDTO obj) {
		ProdutoComandaDTO produtoComanda = service.update(id_comanda, id, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoComanda);
	}

	@PutMapping(value = "/{id_comanda}")
	public ResponseEntity<ProdutoComandaDTO> updateComanda(@PathVariable Long id_comanda,
			@RequestBody @Valid ProdutoComandaDTO obj) {
		ProdutoComandaDTO produtoComanda = service.update(id_comanda, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoComanda);
	}

	@DeleteMapping(value = "/{id_comanda}/{id}")
	public ResponseEntity<Long> deleteProdutoComanda(@PathVariable Long id_comanda, @PathVariable Long id) {
		service.delete(id_comanda, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<ProdutoComandaDTO>> findAll() {
		List<ProdutoComandaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<List<ProdutoComandaDTO>> findByComanda(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findByComanda(id));
	}

	@GetMapping(value = "/{id}/{id_comanda}")
	public ResponseEntity<Object> findByProdutoComanda(@PathVariable Long id, @PathVariable Long id_comanda) {
		return ResponseEntity.ok().body(service.findByProdutoComanda(id, id_comanda));
	}
}
