package com.keny.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.keny.api.modal.Transportadora;
import com.keny.api.service.TransportadoraService;

@RestController
@RequestMapping("/transportadoras")
public class TransportadoraResource {
	
	@Autowired
	private TransportadoraService service;
	
	@PostMapping
	public ResponseEntity<Transportadora> save(@RequestBody Transportadora transportadora){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.seve(transportadora));		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transportadora> findByTransportadora(@PathVariable Integer id){
		return  ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping
	public ResponseEntity<Transportadora> updateByTransportadora(@RequestBody Transportadora transportadora){
		return ResponseEntity.ok(service.updade(transportadora));
	}
	
	@GetMapping
	public ResponseEntity<List<Transportadora>> list(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteTransportadora(@PathVariable Integer id){
		service.detete(id);
	}

}
