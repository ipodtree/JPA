package com.efrei;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Entity

public class Van extends Vehicle{
	
	
	String maxWeight;
	
	
	public Van() {
		super();
	}
	
	public String getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(String weight) {
		this.maxWeight = weight;
	}
	
	public static void main(String [] a){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		Van v = new Van();
		v.setId(2);
		v.setPlateNumber("V1234");
		v.setMaxWeight("1000");
		entityManager.persist(v);
		
		entityManager.getTransaction().commit();  
		entityManager.close();  
		emf.close();
	}
	
	
}
