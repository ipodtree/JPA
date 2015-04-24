package com.efrei;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Entity

public class Car extends Vehicle{

	String numberOfSeats;
	
	
	public Car() {
		super();
	}
	
	public String getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(String number) {
		this.numberOfSeats = number;
	}
	
	public static void main(String [] a){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		Car c = new Car();
		c.setId(1);
		c.setPlateNumber("C1234");
		c.setNumberOfSeats("30");
		entityManager.persist(c);
		
		entityManager.getTransaction().commit();  
		entityManager.close();  
		emf.close();
	}
	
	
}
