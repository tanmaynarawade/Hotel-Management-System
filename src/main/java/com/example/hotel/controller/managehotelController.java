package com.example.hotel.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.Entity.hotelEntity;
import com.example.hotel.Entity.managehotelEntity;
import com.example.hotel.Service.managehotelService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/managehotel")
public class managehotelController {
	
	@Autowired
	private managehotelService service;
	
	@GetMapping("/getall")
	public ResponseEntity<List<managehotelEntity>> allhotels() {
				return ResponseEntity.ok(service.getall());
	}
	
	@PostMapping("/addhotel")
	public ResponseEntity<String> addhotel(@Valid @RequestBody managehotelEntity e) {
		service.addnewhotel(e);
		return ResponseEntity.ok("Hotel added successfully!");
	}
	
	 @DeleteMapping("/delethotel")
		public String deletebyid(@PathVariable int id) {
			return service.deleteById(id);
	    }
	 @PutMapping("/update/{id}")
	    public managehotelEntity updatehotel(@PathVariable int id, @RequestBody managehotelEntity h ) {     
	        
	        return service.updatehotel(id,h);
	    }
	// 🔍 Get hotels by city
	  @GetMapping("/city/{city}")
	    public ResponseEntity<List<managehotelEntity>> getByCity(@PathVariable String city) {
	        return ResponseEntity.ok(service.getHotelsByCity(city));
	    }

	    // 🔍 Get hotels by rating
	    @GetMapping("/rating/{rating}") 
	    public ResponseEntity<List<managehotelEntity>> getByRating(@PathVariable double rating) {
	        return ResponseEntity.ok(service.getHotelsByRating(rating));
	    }
}
