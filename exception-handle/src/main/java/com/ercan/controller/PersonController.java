package com.ercan.controller;

import com.ercan.entity.Person;
import com.ercan.exception.ApiRequestException;
import com.ercan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPersons(){
        throw new ApiRequestException("Cannot get all persons with custom exception");
        //return ResponseEntity.ok(personService.getAll());
    }

    @PostMapping("/save")
    public void createPerson(@RequestBody Person person){
        personService.save(person);
    }

}
