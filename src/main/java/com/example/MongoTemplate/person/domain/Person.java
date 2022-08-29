package com.example.MongoTemplate.person.domain;
import com.example.MongoTemplate.person.infraestructure.dto.PersonInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

@Document(collection = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Person {
   @Id
   private String personId;
   private String name;
   private long age;
   private List<String> favoriteBooks;
   private Date dateOfBirth;

    public Person(String name, List<String> childrenName, Date dateOfBirth) {
        this.name = name;
        this.favoriteBooks = childrenName;
        this.dateOfBirth = dateOfBirth;
        this.age = getDiffYears(dateOfBirth, new Date());
    }

    public Person(PersonInputDTO person) {
        setPersonId(person.getPersonId());
        setName(person.getName());
        setAge(person.getAge());
        setDateOfBirth(person.getDateOfBirth());
        setFavoriteBooks(person.getFavoriteBooks());
    }

    // standard getters and setters
   private int getDiffYears(Date first, Date last) {
       Calendar a = getCalendar(first);
       Calendar b = getCalendar(last);
       int diff = b.get(YEAR) - a.get(YEAR);
       if (a.get(MONTH) > b.get(MONTH) ||
               (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
           diff--;
       }
       return diff;
   }
   private Calendar getCalendar(Date date) {
       Calendar cal = Calendar.getInstance(Locale.US);
       cal.setTime(date);
       return cal;
   }
}