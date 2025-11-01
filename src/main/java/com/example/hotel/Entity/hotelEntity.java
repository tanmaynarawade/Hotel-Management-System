package com.example.hotel.Entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class hotelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String name;
	private String gender;
	private int age;
	private String contact;
	private String email;
	private String password;
	
	@CreatedDate
	private Instant login_date;

	public hotelEntity(int id, @NotBlank String name, String gender, int age, String contact, String email,
			String password, Instant login_date) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.login_date = login_date;
	}

	@Override
	public String toString() {
		return "HotelEntity [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", contact="
				+ contact + ", email=" + email + ", password=" + password + ", login_date=" + login_date + "]";
	}

	public hotelEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Instant getLogin_date() {
		return login_date;
	}

	public void setLogin_date(Instant login_date) {
		this.login_date = login_date;
	}
	
	
	
	
}
