package com.keny.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.out.println("Entrou aqui :)");
		return ResponseEntity.status(HttpStatus.CREATED).body(service.seve(transportadora));		
	}

}
