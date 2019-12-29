package com.keny.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keny.api.modal.Transportadora;
import com.keny.api.repository.TransortadoraRepository;
import com.keny.api.service.TransportadoraService;

@Service
public class TransportadoraServiceImpl implements TransportadoraService {
	
	@Autowired
	private TransortadoraRepository repository;

	@Override
	public Transportadora seve(Transportadora transportadora) {
		return repository.save(transportadora);
	}

}
