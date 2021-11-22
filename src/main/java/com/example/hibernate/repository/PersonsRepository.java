package com.example.hibernate.repository;

import com.example.hibernate.model.entity.PersonId;
import com.example.hibernate.model.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PersonsRepository extends JpaRepository <Persons, PersonId> {

    List<Persons> findByCityOfLiving (String city);
    List<Persons> findByPersonIdAgeLessThanOrderByPersonIdAge (int age);
    //List<Persons> findByPersonIdAgeLessThan (int age); РЕЗУЛЬТАТ ТОЖЕ ОТСОРТИРОВАН ПО ВОЗРАСТУ
    Optional<Persons> findByPersonIdNameAndPersonIdSurname(String name, String surname);



}