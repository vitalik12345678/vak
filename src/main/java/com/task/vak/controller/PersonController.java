package com.task.vak.controller;

import com.task.vak.DTO.PersonCreateRequest;
import com.task.vak.DTO.PersonProfileResponse;
import com.task.vak.DTO.PersonUpdateRequest;
import com.task.vak.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/person/")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "v1/{email}")
    public ResponseEntity<PersonProfileResponse> getPerson(@PathVariable String email) {
        return personService.getPerson(email);
    }

    @GetMapping("v1/{from}/{amount}")
    public ResponseEntity<List<PersonProfileResponse>> getPersonList(@PathVariable Integer amount, @PathVariable Integer from) {
        return personService.getPersonList(from, amount);
    }

    @DeleteMapping("v1/{email}")
    public ResponseEntity<PersonProfileResponse> deletePerson(@PathVariable String email) {
        return personService.deletePerson(email);
    }

    @PostMapping("v1/")
    public ResponseEntity<PersonProfileResponse> createPerson(@Valid @RequestBody PersonCreateRequest personCreateRequest) {
        return personService.createPerson(personCreateRequest);
    }

    @PutMapping("v1/{email}")
    public ResponseEntity<PersonProfileResponse> updatePerson(@PathVariable String email, @Valid @RequestBody PersonUpdateRequest personUpdateRequest) {
        return personService.updatePerson(personUpdateRequest, email);
    }

}