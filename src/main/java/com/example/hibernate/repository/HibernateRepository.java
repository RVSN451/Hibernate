package com.example.hibernate.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HibernateRepository {
    @PersistenceContext
    EntityManager entityManager;

}
