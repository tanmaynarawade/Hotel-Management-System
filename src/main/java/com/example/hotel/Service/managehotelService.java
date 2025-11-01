package com.example.hotel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.Entity.managehotelEntity;
import com.example.hotel.Repo.managehotelRepo;

import jakarta.validation.Valid;


@Service
public class managehotelService {

	@Autowired
	private managehotelRepo repo;

	public List<managehotelEntity> getall() {
		
		return repo.findAll();
	}

	public void addnewhotel(@Valid managehotelEntity e) {
		repo.save(e);
		
	}

	public String deleteById(int id) {
		repo.deleteById(id);
		return "Hotel delete successfully";
	}

	public managehotelEntity updatehotel(int id, managehotelEntity h) {
		Optional <managehotelEntity> o = repo.findById(id);
		if(o.isPresent())
		{
			managehotelEntity e = o.get();
			e.setCity(h.getCity());
			e.setDiscription(h.getDiscription());
			e.setPlace(h.getPlace());
			e.setHotelname(h.getHotelname());
			repo.save(e);
			return e;
		}
		return null;
	}
	
	 public List<managehotelEntity> getHotelsByCity(String city) {
	        return repo.findByCity(city);
	    }

	    public List<managehotelEntity> getHotelsByRating(double rating) {
	        return repo.findByRatingGreaterThanEqual(rating);
	    }
	
	
	



}
