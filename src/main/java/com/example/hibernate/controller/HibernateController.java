package com.example.hibernate.controller;


import com.example.hibernate.service.HibernateService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HibernateController {
    HibernateService hibernateService;

    public HibernateController (HibernateService hibernateService) {
        this.hibernateService = hibernateService;
    }
}


