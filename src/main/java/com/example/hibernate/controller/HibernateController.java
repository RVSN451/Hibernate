package com.example.hibernate.controller;



import com.example.hibernate.model.entity.Persons;
import com.example.hibernate.repository.HibernateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HibernateController {
    HibernateRepository hibernateRepository;

    public HibernateController (HibernateRepository hibernateRepository) {
        this.hibernateRepository = hibernateRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city){
        return hibernateRepository.getPersonsByCity(city);
    }
}


