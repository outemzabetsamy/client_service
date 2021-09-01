package com.sanhotels.client.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClientEntity {
	public ClientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClientEntity(String id, String nomClient, String prenomClient, String typeClient, String civiliteClient,
			int ageClient, String numIDNational, String adresseClient, String numTelClient,Long idHotel,String username) {
		super();
		
		this.id = id;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.typeClient = typeClient;
		this.civiliteClient = civiliteClient;
		this.ageClient = ageClient;
		this.numIDNational = numIDNational;
		this.adresseClient = adresseClient;
		this.numTelClient = numTelClient;
		this.idHotel = idHotel;
		this.username = username;
	}
	
	public String getId() {
		return id;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}
	public String getCiviliteClient() {
		return civiliteClient;
	}
	public void setCiviliteClient(String civiliteClient) {
		this.civiliteClient = civiliteClient;
	}
	public int getAgeClient() {
		return ageClient;
	}
	public void setAgeClient(int ageClient) {
		this.ageClient = ageClient;
	}
	public String getNumIDNational() {
		return numIDNational;
	}
	public void setNumIDNational(String numIDNational) {
		this.numIDNational = numIDNational;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public String getNumTelClient() {
		return numTelClient;
	}
	public void setNumTelClient(String numTelClient) {
		this.numTelClient = numTelClient;
	}
	@Id
	
private String id;
public void setId(String id) {
		this.id = id;
	}
private String nomClient;
private String prenomClient;
private String typeClient;
private String civiliteClient;
private int ageClient;
private String numIDNational;
private String adresseClient;
private String numTelClient;
private Long idHotel;
private String username;
public Long getIdHotel() {
	return idHotel;
}
public void setIdHotel(Long idHotel) {
	this.idHotel = idHotel;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

}
