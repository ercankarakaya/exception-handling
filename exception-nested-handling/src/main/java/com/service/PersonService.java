package com.service;

import com.entity.Person;
import com.exception.PersonNotFoundException;
import com.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found!"));
    }

}
