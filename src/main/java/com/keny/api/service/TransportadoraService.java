package com.keny.api.service;

import com.keny.api.modal.Transportadora;

public interface TransportadoraService {
	
	Transportadora seve(Transportadora transportadora);

	Transportadora findById(Integer id);

	Transportadora updade(Transportadora transportadora);

}
