package com.example.hotel.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.hotel.Service.hotelService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/hotel")
public class hotelController {

	@Autowired
	private hotelService hs;
	
	@GetMapping("/all")
	public ResponseEntity<List<hotelEntity>> getalluser() {
		return ResponseEntity.ok(hs.getall());
	}

	@PostMapping("/adduserr")
	public ResponseEntity<String> addUser(@Valid @RequestBody hotelEntity h) {
		hs.addnewUserr(h);
		return ResponseEntity.ok("User added successfully!");
	}
	
	 @PostMapping("/login")
	  public ResponseEntity<?> login(  @RequestBody hotelEntity h) {
	  	Optional<hotelEntity>  existing =  hs.getByEmail(h.getEmail());
	  	
	  	if(existing.isPresent() && existing.get().getPassword().equals(h.getPassword()))
	  	{
	  		return ResponseEntity.ok("Login successful");
	  	}
	  	
	  	return ResponseEntity.status(401).body("Invalid credentials");
	  }
	 
	 @DeleteMapping("/deleteuser")
		public String deletebyid(@PathVariable int id) {
			return hs.deleteById(id);
	    }
	 
	 @PutMapping("/update/{id}")
	    public hotelEntity updateuser(@PathVariable int id, @RequestBody hotelEntity h ) {
	        //TODO: process PUT request
	        
	        return hs.updateproduct(id,h);
	    }
	
	
	
}
