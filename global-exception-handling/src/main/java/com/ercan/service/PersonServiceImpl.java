package com.ercan.service;

import com.ercan.entity.Person;
import com.ercan.exception.BusinessException;
import com.ercan.exception.EmptyInputException;
import com.ercan.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public Person save(Person person) {
        if (StringUtils.isEmpty(person.getName()))
            throw new EmptyInputException("Input fields are empty!");
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = personRepository.findAll();
        if (personList.isEmpty())
            throw new BusinessException("List completely empty!");
        return personList;
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
