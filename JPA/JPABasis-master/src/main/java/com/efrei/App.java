package com.efrei;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		Person p = new Person();
		p.setId(1);
		p.setName("clement");
		entityManager.persist(p);
		
		Person p2 = new Person();
		p2.setId(2);
		p2.setName("enzo");
		entityManager.persist(p2);
		
		Car c = new Car();
		c.setId(1);
		c.setPlateNumber("C1234");
		c.setNumberOfSeats("30");
		entityManager.persist(c);
		
		Van v = new Van();
		v.setId(2);
		v.setPlateNumber("V1234");
		v.setMaxWeight("1000");
		entityManager.persist(v);
		
		Rent r= new Rent();
		r.setRentId(1);
		r.setPerson(p);
		r.setVehicle(c);
		entityManager.persist(r);
		
		Rent r2= new Rent();
		r2.setRentId(2);
		r2.setPerson(p);
		r2.setVehicle(v);
		entityManager.persist(r2);
		


		
		List<Person> liste = entityManager.createQuery("SELECT p FROM Person p WHERE p.personID = 1").getResultList();
		System.out.println("The first person is: "+((Person)liste.get(0)).getName());
		
		tx.commit();
    }
}
