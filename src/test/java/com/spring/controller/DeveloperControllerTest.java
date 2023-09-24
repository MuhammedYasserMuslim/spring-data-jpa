package com.spring.controller;

import com.spring.model.Developer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeveloperControllerTest {

    @Autowired
    TestRestTemplate template;

    @Test
    void findByIdFound(){
        Long id = 7L;
        ResponseEntity<Developer> response = template.getForEntity("/developer/developer?id="+id,Developer.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
}
