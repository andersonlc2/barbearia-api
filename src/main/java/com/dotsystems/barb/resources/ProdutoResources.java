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

import com.dotsystems.barb.dtos.ProdutoDTO;
import com.dotsystems.barb.services.ProdutoService;

@Controller
@RequestMapping(value = "/produtos")
@CrossOrigin(origins = "*", maxAge = 36000)
public class ProdutoResources {

	@Autowired
	private ProdutoService service;

	@PostMapping
	public ResponseEntity<ProdutoDTO> saveProduto(@RequestBody @Valid ProdutoDTO obj) {
		service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable Long id, @RequestBody @Valid ProdutoDTO obj) {
		ProdutoDTO Produto = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(Produto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deleteProduto(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<ProdutoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
		ProdutoDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
