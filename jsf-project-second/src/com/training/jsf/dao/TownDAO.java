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
import com.training.jsf.model.Town;

@Named
@ApplicationScoped
public class TownDAO {

	@PersistenceUnit(name = "jsf-project-second")
	private EntityManagerFactory entityManagerFactory;

	@Transactional
	public void saveTown(final Town town) {

		EntityManager enManager = this.entityManagerFactory.createEntityManager();

		enManager.joinTransaction();
		enManager.persist(town);
		enManager.close();
	}

	@Transactional
	public void deleteTown(final Town town) {

		EntityManager enManager = this.entityManagerFactory.createEntityManager();

		enManager.joinTransaction();
		Town merged = enManager.merge(town);
		merged.setCity(null);
		enManager.remove(merged);
		enManager.close();

	}

	public List<Town> getAllTown(final Long selectedCity) {
		if (selectedCity == null) {
			return null;
		}
		EntityManager enManager = this.entityManagerFactory.createEntityManager();
		Query createQuery = enManager.createQuery("select t from Town t where t.city.cityId = ?1");
		createQuery.setParameter(1,
		                         selectedCity);
		List<Town> resultList = createQuery.getResultList();
		return resultList;
	}

	@Transactional
	public void updateTown(final Town town) {
		EntityManager enManager = this.entityManagerFactory.createEntityManager();

		enManager.joinTransaction();
		enManager.merge(town);

		enManager.close();

	}

	public City getCity(final Long selectedCity) {
		EntityManager enManager = this.entityManagerFactory.createEntityManager();

		City city = enManager.find(City.class,
		                           selectedCity);
		enManager.close();

		return city;
	}

}
