package com.acornejo.springDataDemo.Service;

import com.acornejo.springDataDemo.Pojo.Person;
import com.mongodb.MongoClient;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class PersonRepositoryImpl implements PersonRepository {

    MongoOperations operations = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "personas"));


    public List<Person> findByName(String name) {

        List<Person> people = operations.find(query(where("nombre").is(name)), Person.class);
        return people;
    }

    public List<Person> findByLastnameOrderByFirstnameAsc(String lastname) {
        return null;
    }

    public List<Person> findByLastnameOrderByFirstnameDesc(String lastname) {
        return null;
    }

    public List<Person> findFirst3ByLastname(String lastname, Sort sort) {
        List<Person> people = (List<Person>) operations.find(query(where("lastName").is(lastname)), Person.class);

        return people;
    }

    public <S extends Person> S save(S s) {
        System.out.println(operations.save(s).toString());
        return operations.save(s);
    }

    public <S extends Person> List<S> saveAll(Iterable<S> iterable) {
        for (Person p :
                iterable) {
            operations.save(p);
        }
        return null;
    }

    public Optional<Person> findById(String s) {
        return Optional.of(operations.findById(s, Person.class));
    }

    public boolean existsById(String s) {
        return false;
    }

    public List<Person> findAll() {
        List<Person> people = operations.findAll(Person.class);
        return people;
    }

    public Iterable<Person> findAllById(Iterable<String> iterable) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(String s) {

    }

    public void delete(Person person) {

    }

    public void deleteAll(Iterable<? extends Person> iterable) {

    }

    public void deleteAll() {

    }

    public List<Person> findAll(Sort sort) {
        return null;
    }

    public Page<Person> findAll(Pageable pageable) {
        return null;
    }

    public <S extends Person> S insert(S s) {
        return null;
    }

    public <S extends Person> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    public <S extends Person> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    public <S extends Person> List<S> findAll(Example<S> example) {
        return null;
    }

    public <S extends Person> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    public <S extends Person> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    public <S extends Person> long count(Example<S> example) {
        return 0;
    }

    public <S extends Person> boolean exists(Example<S> example) {
        return false;
    }
}
