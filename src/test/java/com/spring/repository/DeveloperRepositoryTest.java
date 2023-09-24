package com.spring.repository;

import com.spring.model.Developer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DeveloperRepositoryTest {

    @Autowired
    DeveloperRepository developerRepository;

    @Test
    void testing (){
        Optional<Developer> developer = developerRepository.findById(7L);
        assertEquals(true,developer.isPresent());
    }
}
