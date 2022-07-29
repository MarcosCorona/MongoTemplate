package com.example.MongoTemplate.person.infraestructure.controllers;

import com.example.MongoTemplate.person.application.services.PersonDAL;

import com.example.MongoTemplate.person.application.servicesImp.PersonDALImpl;
import com.example.MongoTemplate.person.infraestructure.dto.PersonInputDTO;
import com.example.MongoTemplate.person.infraestructure.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class AddPersonController {
    @Autowired
    private PersonDALImpl personDAL;

    @PostMapping
    public PersonOutputDto addPerson(@RequestBody PersonInputDTO personInputDto){
        return personDAL.savePerson(personInputDto);
    }
}
