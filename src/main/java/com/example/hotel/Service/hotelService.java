package com.example.hotel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.Entity.hotelEntity;
import com.example.hotel.Repo.hotelRepo;

import jakarta.validation.Valid;

@Service
public class hotelService {

	@Autowired
	private hotelRepo hr;
	
	 @Autowired
	 private EmailService emailService;

	public List<hotelEntity> getall() {
		
		return hr.findAll();
	}

	public String addnewUserr(@Valid hotelEntity h) {
		hr.save(h);
		String subject = "Welcome to PawsIndia 🐾";
        String message = "Hi " + h.getName() + ",\n\n" +
                "Welcome to our PawsIndia Store! 🎉\n" +
                "Your registration was successful.\n\n" +
                "We’re excited to have you with us.\n\n" +
                "Warm regards,\n" +
                "PawsIndia Team";
        
        System.out.println("Email from service: "+h.getEmail());

        emailService.sendEmail(h.getEmail(), subject, message);

        return "User registered and email sent successfully!";
		
	}

	public Optional<hotelEntity> getByEmail(String email) {
		try
		{
			return hr.findByEmail(email);
		}
		catch(Exception e)
		{
			System.out.println("Error fetching customer with email: "+email);
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public String deleteById(int id) {
		hr.deleteById(id);
		return "Record delete successfully";
	}

	public hotelEntity updateproduct(int id, hotelEntity h) {
		Optional <hotelEntity> o = hr.findById(id);
		if(o.isPresent())
		{
			hotelEntity e = o.get();
			e.setAge(h.getAge());
			e.setContact(h.getContact());
			e.setEmail(h.getEmail());
			e.setGender(h.getGender());
			e.setName(h.getName());
			e.setPassword(h.getPassword());
			hr.save(e);
			return e;
	}
		return null;
	}
	
	
	
	
	
}
