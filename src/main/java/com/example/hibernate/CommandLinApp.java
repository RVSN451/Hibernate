package com.example.hibernate;

import com.example.hibernate.model.entity.PersonId;
import com.example.hibernate.model.entity.Persons;
import com.example.hibernate.repository.PersonsRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class CommandLinApp implements CommandLineRunner {

    @Autowired
    private PersonsRepository personsRepository;

    public CommandLinApp(PersonsRepository personsRepository){
        this.personsRepository = personsRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        List<String> names = List.of("Ivan", "Serge", "Ben", "Duck", "Jon");
        List<String> surnames = List.of("Black", "Yang", "Town", "Tor", "Bone");
        List<String> cities = List.of("Moscow", "Omsk", "Orel", "Tver", "Sochi");

        var random = new Random();
        var randomString = new RandomStringUtils();

        IntStream.range(0, 10)
                .forEach(i -> {
                    Persons person = Persons.builder()
                            .personId(new PersonId(
                                    names.get(random.nextInt(names.size())),
                                    surnames.get(random.nextInt(surnames.size())),
                                    random.nextInt(55)))
                            .phoneNumber("+7" + randomString.randomNumeric(10))
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .build();
                    personsRepository.save(person);
                });


       /* System.out.println("\n\n");
        System.out.println(personsRepository
                .getFirstByPersonIdNameAndPersonIdSurname("Ben","Town"));
        System.out.println("\n\n");
        System.out.println(personsRepository
                .findByPersonIdNameAndPersonIdSurname("Ben","Town"));
*/

    }
}
