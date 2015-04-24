package com.efrei;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {

	
	@Id
	int vehicleID;
	String plateNumber;
	
	@OneToMany(mappedBy="vehicle",cascade=CascadeType.REMOVE)
	
    private List<Rent> rents;
	
	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
	
	public void addRents(Rent newRent){
		this.getRents().add(newRent);
		newRent.vehicle = this;
	}
	
	public Vehicle() {
		super();
	}
	

	public int getId() {
		return vehicleID;
	}
	public void setId(int id) {
		this.vehicleID = id;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String number) {
		this.plateNumber = number;
	}
	
	
}
