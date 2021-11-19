package com.example.hibernate.app;

import com.example.hibernate.model.entity.PersonId;
import com.example.hibernate.model.entity.Persons;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class CommandLinApp implements CommandLineRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        List<String> names = List.of("Ivan", "Serge", "Ben", "Duck", "Jon");
        List<String> surnames = List.of("Black", "Yang", "Town", "Tor", "Bone");
        List<String> cities = List.of("Moscow", "Omsk", "Orel", "Tver", "Sochi");

        var random = new Random();
        var randomString = new RandomStringUtils();

        IntStream.range(0, 30)
                .forEach(i -> {
                    Persons person = Persons.builder()
                            .personId(new PersonId(
                                    names.get(random.nextInt(names.size())),
                                    surnames.get(random.nextInt(surnames.size())),
                                    random.nextInt(55)))
                            .phone_number("+7" + randomString.randomNumeric(10))
                            .city_of_living(cities.get(random.nextInt(cities.size())))
                            .build();
                    entityManager.persist(person);
                });
    }
}
