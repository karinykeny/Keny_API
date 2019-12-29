package com.keny.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	@Override
	public Transportadora findById(Integer id) {
		Optional<Transportadora> transportadora = repository.findById(id);
		if(!transportadora.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return transportadora.get();
	}

}
