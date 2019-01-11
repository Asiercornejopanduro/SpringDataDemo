package com.acornejo.springDataDemo.Pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "personas")
public class Person {
    @Id
    private String id;
    @Field("nombre")
    private String name;
    @Field("apellidos")
    private String lastName;


    public Person() {
        super();
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
