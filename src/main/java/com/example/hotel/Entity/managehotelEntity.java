package com.example.hotel.Entity;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import com.example.petStore.Entity.petStoreEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class managehotelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String hotelname;
	
	@Lob
	private String img;
	
	@Lob
	@NotBlank
private String discription;
	
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<RoomEntity> room;
	
	@Size(min =1,max =5,message = "Rating must be less then 6")
	private float rating;
	private String place;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	
	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public managehotelEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ManageHotelEntity [id=" + id + ", city=" + city + ", hotelname=" + hotelname + ", img=" + img
				+ ", discription=" + discription + ", rating=" + rating + ", place=" + place + "]";
	}

	public managehotelEntity(int id, @NotBlank String city, @NotBlank String hotelname, String img,
			@NotBlank String discription, @Size(min = 1, max = 5, message = "Rating must be less then 6") float rating,
			String place) {
		super();
		this.id = id;
		this.city = city;
		this.hotelname = hotelname;
		this.img = img;
		this.discription = discription;
		this.rating = rating;
		this.place = place;
	}

	
	
	
	

}
