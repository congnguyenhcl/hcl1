package com.hcl.cong.hibernate1.hibernate_demo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Employee firstEmployee = new Employee(1121, "Peter", "Holland", "Manager", 120000);

		Employee secondEmployee = new Employee(1141, "Bruce", "Brenner", "Analyst", 90000);

		entityManager.persist(firstEmployee);
		entityManager.persist(secondEmployee);

		entityManager.getTransaction().commit();

		entityManager.close();
		factory.close();
	}
}
