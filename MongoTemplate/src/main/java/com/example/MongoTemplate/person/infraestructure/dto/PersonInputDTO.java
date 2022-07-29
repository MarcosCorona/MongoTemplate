package com.example.MongoTemplate.person.infraestructure.dto;

import com.example.MongoTemplate.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDTO {
    private String personId;
    private String name;
    private long age;
    private List<String> favoriteBooks;
    private Date dateOfBirth;


    public PersonInputDTO(Person person ) {
        setPersonId(person.getPersonId());
        setName(person.getName());
        setAge(person.getAge());
        setDateOfBirth(person.getDateOfBirth());
        setFavoriteBooks(person.getFavoriteBooks());
    }
}
