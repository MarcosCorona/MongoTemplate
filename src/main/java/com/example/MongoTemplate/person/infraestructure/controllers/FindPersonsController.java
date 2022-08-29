package com.example.MongoTemplate.person.infraestructure.controllers;

import com.example.MongoTemplate.person.application.services.PersonDAL;
import com.example.MongoTemplate.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class FindPersonsController {
    @Autowired
    private PersonDAL personDAL;

    @GetMapping("/{name}")
    public List<Person> getPersonByName(@PathVariable("name") String name){
        return personDAL.findByName(name);
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personDAL.getAllPerson();
    }

    @GetMapping("/pag")
    public List<Person> getPersonPaginated(){
        return personDAL.getAllPersonPaginated(0, 2);
    }

    @GetMapping("/ageRange")
    public List<Person> getPersonsByAgeRange(@RequestParam int lower, @RequestParam int upper){
        return personDAL.findByAgeRange(lower, upper);
    }



}
