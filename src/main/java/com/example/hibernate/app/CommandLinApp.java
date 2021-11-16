package com.example.hibernate.app;

import com.example.hibernate.model.entity.Persons;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CommandLinApp implements CommandLineRunner {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Persons person1 = Persons.builder()
                .name("TTT")
                .surname("jyfg")
                .age(5)
                .phone_number("jghv")
                .city_of_living("jgh")
                .build();

        entityManager.persist(person1);

    }
}
