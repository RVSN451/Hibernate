package com.example.hibernate.service;

import com.example.hibernate.repository.HibernateRepository;
import org.springframework.stereotype.Service;

@Service
public class HibernateService {
    HibernateRepository hibernateRepository;

    public HibernateService (HibernateRepository hibernateRepository) {
        this.hibernateRepository = hibernateRepository;
    }
}
