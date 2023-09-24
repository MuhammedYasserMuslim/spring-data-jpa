package com.spring.services;

import com.spring.model.Developer;
import com.spring.repository.DeveloperRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class DeveloperServicesTest {

    @Autowired
    DeveloperServices developerServices;
    @MockBean
    DeveloperRepository developerRepository;

    @Test
    void findByIDFound(){
        Optional<Developer> param =Optional.of(new Developer());
        Mockito.when(developerRepository.findById(Mockito.anyLong())).thenReturn(param);
        Optional<Developer> developer = developerServices.findById(7L);
        assertEquals(true,developer.isPresent());
    }


}
