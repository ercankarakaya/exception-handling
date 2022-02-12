package com.ercan.controller;

import com.ercan.entity.Person;
import com.ercan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/save")
    public ResponseEntity<?> saveEmployee(@RequestBody Person person) {
        Person personSaved = personService.save(person);
        return new ResponseEntity<>(personSaved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPersons() {
        List<Person> personList = personService.getAll();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpById(@PathVariable Long id) {
        Person person = personService.getById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmpById(@PathVariable Long id) {
        personService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Person person) {
        Person personSaved = personService.save(person);
        return new ResponseEntity<>(personSaved, HttpStatus.CREATED);
    }

}
