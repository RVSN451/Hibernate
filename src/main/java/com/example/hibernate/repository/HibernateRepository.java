/*package com.example.hibernate.repository;

import com.example.hibernate.model.entity.Persons;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HibernateRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Persons> getPersonsByCity(String city) {
        return entityManager
                .createQuery(
                        "select person from Persons person where person.city_of_living = :city",
                        Persons.class)
                .setParameter("city", city)
                .getResultList();
    }
}*/
