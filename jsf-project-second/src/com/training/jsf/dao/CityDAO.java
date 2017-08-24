package com.training.jsf.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.training.jsf.model.City;

@Named
@ApplicationScoped
public class CityDAO {

	@PersistenceUnit(name = "jsf-project-second")
	private EntityManagerFactory entityManagerFactory;

	@Transactional
	public void saveCity(final City city) {

		EntityManager enManager = this.entityManagerFactory.createEntityManager();

		enManager.joinTransaction();
		enManager.persist(city);
		enManager.close();

	}

	@Transactional
	public void deleteCity(final City city) {

		EntityManager enManager = this.entityManagerFactory.createEntityManager();

		enManager.joinTransaction();
		City merged = enManager.merge(city);

		enManager.remove(merged);
		enManager.close();

	}

	public List<City> getAllCities() {
		EntityManager enManager = this.entityManagerFactory.createEntityManager();
		Query createQuery = enManager.createQuery("select c from City c");
		List<City> resultList = createQuery.getResultList();
		return resultList;
	}

	@Transactional
	public void updateCity(final City city) {
		EntityManager enManager = this.entityManagerFactory.createEntityManager();

		enManager.joinTransaction();
		enManager.merge(city);

		enManager.close();

	}

}
