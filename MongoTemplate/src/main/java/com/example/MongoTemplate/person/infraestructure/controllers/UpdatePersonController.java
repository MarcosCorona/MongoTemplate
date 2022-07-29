package com.example.MongoTemplate.person.infraestructure.controllers;

import com.example.MongoTemplate.person.application.services.PersonDAL;
import com.example.MongoTemplate.person.application.servicesImp.PersonDALImpl;
import com.example.MongoTemplate.person.domain.Person;
import com.example.MongoTemplate.person.infraestructure.dto.PersonInputDTO;
import com.example.MongoTemplate.person.infraestructure.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class UpdatePersonController {

    @Autowired
    private PersonDALImpl personDAL;

    @PutMapping("/{personId}")
    public PersonOutputDto updatePerson(@PathVariable String personId, @RequestBody PersonInputDTO  person2){
        return personDAL.updateOnePerson(personId,person2);
    }
}
