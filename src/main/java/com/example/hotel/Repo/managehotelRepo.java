package com.example.hotel.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.Entity.managehotelEntity;
@Repository
public interface managehotelRepo extends JpaRepository<managehotelEntity, Integer> {

	

    List<managehotelEntity> findByCity(String city);

    List<managehotelEntity> findByRatingGreaterThanEqual(double rating);
}
