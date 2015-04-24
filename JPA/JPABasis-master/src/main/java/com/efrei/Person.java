package com.efrei;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;


@Entity
public class Person {
	@Id
	int personID;
	String name;
	
	public Person() {
		super();
		}
	
	@OneToMany(mappedBy="person",cascade=CascadeType.REMOVE)
	
    private List<Rent> rents;
	
	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
	public void addRents(Rent newRent){
		this.getRents().add(newRent);
		newRent.person = this;
	}
	
	

	public int getId() {
		return personID;
	}
	public void setId(int id) {
		this.personID = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String [] a){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		Person p = new Person();
		p.setId(1);
		p.setName("clement");
		
	
		/*Rent r1 = new Rent();
		r1.setId(1);
		Calendar c1_1 = Calendar.getInstance();
		c1_1.set(2014, 1, 1);
		r1.setBegindate(c1_1);
		Calendar c1_2 = Calendar.getInstance();
		c1_2.set(2015, 1, 1);
		r1.setEnddate(c1_2);
		r1.setPerson(p);
		
		Rent r2 = new Rent();
		r2.setId(2);
		Calendar c2_1 = Calendar.getInstance();
		c2_1.set(2014, 2, 1);
		r2.setBegindate(c2_1);
		Calendar c2_2 = Calendar.getInstance();
		c2_2.set(2015, 2, 1);
		r2.setEnddate(c2_2);
		r2.setPerson(p);
		
		List<Rent> rents = new ArrayList<Rent>();
		rents.add(r1);
		rents.add(r2);
		
		p.setRents(rents);*/
		
		entityManager.persist(p);
		
		List<Person> liste = entityManager.createQuery("SELECT p FROM Person p WHERE p.personID = 1").getResultList();
		System.out.println("The first person is: "+((Person)liste.get(0)).getName());
		
		entityManager.getTransaction().commit();  
		entityManager.close();  
		emf.close();
		
	}
	 
	
}
