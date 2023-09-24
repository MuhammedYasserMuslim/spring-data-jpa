package com.spring.services;

import com.spring.model.Developer;
import com.spring.repository.DeveloperRepository;
import com.spring.base.BaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperServices{

    @Autowired
    DeveloperRepository developerRepository;


    public Long count() {
        return developerRepository.count();
    }


    public List<Developer> findAll() {
        return developerRepository.findAll();
    }


    public Optional<Developer> findById(Long aLong) {
        return developerRepository.findById(aLong);
    }


    public void insert(Developer developer) {
        developerRepository.save(developer);
    }


    public void update(Developer developer) {
        developerRepository.save(developer);
    }


    public void deleteById(Long aLong) {
        developerRepository.deleteById(aLong);
    }
}
