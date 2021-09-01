package com.sanhotels.client.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.sanhotels.client.entity.ClientEntity;
import com.sanhotels.client.exception.ClientNotFoundException;
import com.sanhotels.client.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	
private ClientService clientService;
@Autowired
public ClientController(ClientService clientService) {
	this.clientService=clientService;
}

@GetMapping("/all")
public List<ClientEntity> getAllClientsOfThHotel(@RequestParam("idhotel") Long idhotel){
	return clientService.findAllByIdHotel(idhotel);
}
@GetMapping("/all/{id}")
public ClientEntity getClientById(@PathVariable String id,@RequestParam("idhotel") Long idhotel) {
	return clientService.findClientById(id,idhotel).orElseThrow(()->new ClientNotFoundException("Client with id"+id+"not found exception"));
}

@PostMapping(value="/add")

public ResponseEntity<Void> addClient(@RequestBody ClientEntity c){
	if(c.getId()==null) {
	Timestamp timestampp=new Timestamp(System.currentTimeMillis());
	String idClientGen=timestampp.getTime()+"";
	c.setId(idClientGen);
	}
	ClientEntity clientAdded=clientService.addClient(c);
	if(clientAdded == null) {
		return ResponseEntity.noContent().build();
	}
	URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(clientAdded.getId()).toUri();
	return ResponseEntity.created(location).build();
}


@PostMapping(value="/addwithresponse")

public ClientEntity addClientWithResponse(@RequestBody ClientEntity c){
	if(c.getId()==null) {
	Timestamp timestampp=new Timestamp(System.currentTimeMillis());
	String idClientGen=timestampp.getTime()+"";
	c.setId(idClientGen);
	}
	ClientEntity clientAdded=clientService.addClient(c);
	if(clientAdded == null) {
		return null;
	}
	
	return clientAdded;
}


@DeleteMapping(value="/delete/{id}")
public void deleteClientById(@PathVariable String id,@RequestParam("idhotel") Long idhotel) {
	clientService.deleteClientById(id,idhotel);
}
@PutMapping(value="/edit")
public void editClient(@RequestBody ClientEntity c) {
	clientService.editClient(c);
}

}
