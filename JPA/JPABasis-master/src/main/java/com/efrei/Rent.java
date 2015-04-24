package com.efrei;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rent {
    
	@Temporal(value = TemporalType.DATE)
	private Date begin;
	@Temporal(value = TemporalType.DATE)
	private Date deadline;
	@Id
	private int rentId;
	
	public Rent(){
		super();
	}
	
	
	public int getRentId() {
		return rentId;
	}
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	
	public Date getBegin()
	{
		return begin;
	}
	public void setBegin(Date begin)
	{
		this.begin = begin;
	}
	
	public Date getDeadLine()
	{
		return deadline;
	}
	public void setDeadLine(Date deadline)
	{
		this.deadline = deadline;
	}
	
	
	Vehicle vehicle;
	Person person;
	
	@ManyToOne
	public Vehicle getVehicle(){
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
	}
	@ManyToOne
	public Person getPerson(){
		return person;
	}
	public void setPerson(Person person){
		this.person = person;
	}
	

}
