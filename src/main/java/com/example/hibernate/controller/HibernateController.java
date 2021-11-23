package com.example.hibernate.controller;


import com.example.hibernate.model.entity.Persons;
import com.example.hibernate.repository.PersonsRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
public class HibernateController {
    PersonsRepository personsRepository;

    public HibernateController(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @GetMapping("/hello")
    public String getGreetings() {
        return "Hello from PersonsDB.";
    }

    @GetMapping("/goodbye")
    public String getParting() {
        return "Goodbye from PersonsDB, " +
                SecurityContextHolder.getContext().getAuthentication().getName() + "!!!";
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) {
        return personsRepository.findByCityOfLiving(city);
    }

    @GetMapping("/persons/LessTheSpecifiedAge")
    public List<Persons> getPersonsLessTheSpecifiedAge(@RequestParam("age") int age) {
        return personsRepository.findByPersonIdAgeLessThanOrderByPersonIdAge(age);
    }

    @GetMapping("/persons/TheSpecifiedNameAndSurname")
    public Persons getPersonTheSpecifiedNameAndSurname(@RequestParam("name") String name,
                                                                 @RequestParam("surname") String surname) {
        Persons person = personsRepository.findByPersonIdNameAndPersonIdSurname(name, surname)
                .orElseThrow(() -> new EntityNotFoundException("Person " + name + " " + surname +
                        " not found"));
        return person;
    }
}


