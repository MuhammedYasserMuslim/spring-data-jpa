package com.spring;

import com.spring.model.Developer;
import com.spring.services.DeveloperServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringBootTestingApplicationTests {

    @Autowired
    DeveloperServices developerServices;

    @Test
    void contextLoads() {

    }

    @Test
    void findById(){
        Optional<Developer> developer = developerServices.findById(7L);
        assertEquals(true,developer.isPresent());
    }

}
