package com.acornejo.springDataDemo.Service;

import com.acornejo.springDataDemo.Pojo.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByName(String name);

    List<Person> findByLastnameOrderByFirstnameAsc(String lastname);

    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);

    List<Person> findFirst3ByLastname(String lastname, Sort sort);
}
