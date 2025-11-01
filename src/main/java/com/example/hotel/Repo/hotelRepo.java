package com.example.hotel.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.Entity.hotelEntity;

@Repository
public interface hotelRepo extends JpaRepository<hotelEntity, Integer>{

	public Optional<hotelEntity> findByEmail(String email);
	

}
