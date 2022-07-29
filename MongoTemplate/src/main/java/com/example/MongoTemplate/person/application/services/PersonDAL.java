package com.example.MongoTemplate.person.application.services;

import com.example.MongoTemplate.person.domain.Person;
import com.example.MongoTemplate.person.infraestructure.dto.PersonInputDTO;
import com.example.MongoTemplate.person.infraestructure.dto.PersonOutputDto;

import java.util.Date;
import java.util.List;

public interface PersonDAL {
   PersonOutputDto savePerson(PersonInputDTO person);
   List<Person> getAllPerson();
   List<Person> getAllPersonPaginated(int pageNumber, int pageSize);
   Person findOneByName(String name);
   List<Person> findByName(String name);
   List<Person> findByBirthDateAfter(Date date);
   List<Person> findByAgeRange(int lowerBound, int upperBound);
   List<Person> findByFavoriteBooks(String favoriteBook);
   void updateMultiplePersonAge();
   PersonOutputDto updateOnePerson(String id,PersonInputDTO person);
   String deletePerson(PersonInputDTO person);
   Person findById(String personId);
}