package com.example.hotel.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import com.example.petStore.Entity.userEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class RoomEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int roomno;
	
	private String type;
	
	private int pricepernight;
	
	private String status;
	
	private String decsription;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	@JsonBackReference
	private managehotelEntity hotel;

	public RoomEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomEntity(int id, int roomno, String type, int pricepernight, String status, String decsription,
			managehotelEntity hotel) {
		super();
		this.id = id;
		this.roomno = roomno;
		this.type = type;
		this.pricepernight = pricepernight;
		this.status = status;
		this.decsription = decsription;
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "RoomEntity [id=" + id + ", roomno=" + roomno + ", type=" + type + ", pricepernight=" + pricepernight
				+ ", status=" + status + ", decsription=" + decsription + ", hotel=" + hotel + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPricepernight() {
		return pricepernight;
	}

	public void setPricepernight(int pricepernight) {
		this.pricepernight = pricepernight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDecsription() {
		return decsription;
	}

	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}

	public managehotelEntity getHotel() {
		return hotel;
	}

	public void setHotel(managehotelEntity hotel) {
		this.hotel = hotel;
	}
	
	
	
	
}
