package com.keny.api.service;

import java.util.List;

import com.keny.api.modal.Transportadora;

public interface TransportadoraService {
	
	Transportadora seve(Transportadora transportadora);

	Transportadora findById(Integer id);

	Transportadora updade(Transportadora transportadora);

	List<Transportadora> findAll();

	void detete(Integer id);
	
	List<Transportadora> findAll(Transportadora transportadora);

}
