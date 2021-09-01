package com.sanhotels.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sanhotels.client.entity.ClientEntity;
import com.sanhotels.client.repository.ClientRepository;

@Service
public class ClientService {
	ClientRepository clientRepository;
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository=clientRepository;
	}
	public List<ClientEntity> findAllByIdHotel(Long idhotel) {
		// TODO Auto-generated method stub
		return clientRepository.findAllByIdHotel(idhotel);
	}
	public Optional<ClientEntity> findClientById(String id,Long idhotel) {
		// TODO Auto-generated method stub
		return clientRepository.findByIdAndIdHotel(id,idhotel);
	}
	public ClientEntity addClient(ClientEntity c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}
	public void deleteClientById(String id,Long idhotel) {
		clientRepository.deleteByIdAndIdHotel(id,idhotel);
		
	}
	public void editClient(ClientEntity c) {
		// TODO Auto-generated method stub
		clientRepository.save(c);
	}
	

}
