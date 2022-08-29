package com.example.MongoTemplate.person.infraestructure.dto;

import com.example.MongoTemplate.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDto {
    @Id
    private String personId;
    private String name;
    private long age;
    private List<String> favoriteBooks;
    private Date dateOfBirth;

    public PersonOutputDto (PersonInputDTO persona) {
        setPersonId(persona.getPersonId());
        setName(persona.getName());
        setAge(persona.getAge());
        setDateOfBirth(persona.getDateOfBirth());
        setFavoriteBooks(persona.getFavoriteBooks());

    }

    public PersonOutputDto(Person persona) {
        setPersonId(persona.getPersonId());
        setName(persona.getName());
        setAge(persona.getAge());
        setDateOfBirth(persona.getDateOfBirth());
        setFavoriteBooks(persona.getFavoriteBooks());
    }
}
