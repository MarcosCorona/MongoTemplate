package com.example.MongoTemplate;

import com.example.MongoTemplate.person.application.services.PersonDAL;
import com.example.MongoTemplate.person.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.Date;
@SpringBootApplication
public class MongoTemplateApplication {
	private static final Logger LOG = LoggerFactory.getLogger("AppsDeveloperBlog");
	private final PersonDAL personDAL;

	@Autowired
	public MongoTemplateApplication(PersonDAL personDAL) {
		this.personDAL = personDAL;
	}
	public static void main(String[] args) {
		SpringApplication.run(MongoTemplateApplication.class, args);
	}

}