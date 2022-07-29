package com.example.MongoTemplate.person.application.servicesImp;

import com.example.MongoTemplate.person.application.services.PersonDAL;
import com.example.MongoTemplate.person.domain.Person;
import com.example.MongoTemplate.person.infraestructure.dto.PersonInputDTO;
import com.example.MongoTemplate.person.infraestructure.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public class PersonDALImpl implements PersonDAL {
    private final MongoTemplate mongoTemplate;

    //Implementing Data Access Layer
    @Autowired
    public PersonDALImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public PersonOutputDto savePerson(PersonInputDTO person) {
        Person personSaved = new Person(person);
        mongoTemplate.save(personSaved);
        return new PersonOutputDto(person);
    }
    @Override
    public List<Person> getAllPerson() {
        return mongoTemplate.findAll(Person.class);
    }

    //Using Paginated Queries
    @Override
    public List<Person> getAllPersonPaginated(int pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);
        return mongoTemplate.find(query, Person.class);
    }

    //Getting Object by exact values
    @Override
    public Person findOneByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Person.class);
    }
    @Override
    public List<Person> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Person.class);
    }

    @Override
    public Person findById(String personId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("personId").is(personId));
        return mongoTemplate.findOne(query, Person.class);
    }

    //Finding by Range and in List of Data
    @Override
    public List<Person> findByBirthDateAfter(Date date) {
        Query query = new Query();
        query.addCriteria(Criteria.where("dateOfBirth").gt(date));
        return mongoTemplate.find(query, Person.class);
    }
    @Override
    public List<Person> findByAgeRange(int lowerBound, int upperBound) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(lowerBound)
                .andOperator(Criteria.where("age").lt(upperBound)));
        return mongoTemplate.find(query, Person.class);
    }
    @Override
    public List<Person> findByFavoriteBooks(String favoriteBook) {
        Query query = new Query();
        query.addCriteria(Criteria.where("favoriteBooks").in(favoriteBook));
        return mongoTemplate.find(query, Person.class);
    }

    //update mql
    @Override
    public void updateMultiplePersonAge() {
        Query query = new Query();
        Update update = new Update().inc("age", 1);
        mongoTemplate.findAndModify(query, update, Person.class);;
    }

    @Override
    public PersonOutputDto updateOnePerson(String id, PersonInputDTO newPerson) {
        Person person = findById(id);
        person.setPersonId(newPerson.getPersonId());
        person.setName(newPerson.getName());
        person.setAge(newPerson.getAge());
        person.setDateOfBirth(newPerson.getDateOfBirth());
        person.setFavoriteBooks(newPerson.getFavoriteBooks());
        mongoTemplate.save(person);
        return new PersonOutputDto(person);
    }

    //delete
    @Override
    public String deletePerson(PersonInputDTO person) {
       mongoTemplate.remove(person);
       return "BorradoOk";
    }


}