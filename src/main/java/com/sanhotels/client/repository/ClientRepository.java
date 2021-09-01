package com.sanhotels.client.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanhotels.client.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, String> {

	List<ClientEntity> findAllByIdHotel(Long idhotel);

	Optional<ClientEntity> findByIdAndIdHotel(String id, Long idhotel);

	void deleteByIdAndIdHotel(String id, Long idhotel);
	

}
