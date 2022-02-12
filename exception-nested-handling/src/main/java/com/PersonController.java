package com;

import com.entity.Person;
import com.exception.ResponseApi;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id) {
        Person person = personService.getById(id);
        return ResponseEntity.ok(
                ResponseApi.builder()
                        .timeStamp(LocalDateTime.now())
                        .statusCode(200)
                        .httpStatus(HttpStatus.ACCEPTED)
                        .message("person: " + id)
                        .data(Map.of("person", person))
                        .build());
    }

}
