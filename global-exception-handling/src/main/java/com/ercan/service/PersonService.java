package com.ercan.service;

import com.ercan.entity.Person;

import java.util.List;

public interface PersonService {
    Person save(Person person);

    List<Person> getAll();

    Person getById(Long id);

    void deleteById(Long id);
}
