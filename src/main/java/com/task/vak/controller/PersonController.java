package com.task.vak.controller;

import com.task.vak.DTO.PersonCreateDTO;
import com.task.vak.DTO.PersonFilteredDTO;
import com.task.vak.DTO.PersonProfileDTO;
import com.task.vak.DTO.PersonUpdateDTO;
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

    @GetMapping(value = "v1/filter")
    public ResponseEntity<List<PersonFilteredDTO>> getFilteredPersons(@RequestParam(required = false,name = "name") String name,
                                                                      @RequestParam(required = false,name = "age")Integer age){
        return ResponseEntity.ok( personService.getFilteredPersons(name,age) );
    }

    @GetMapping(value = "v1/{email}")
    public ResponseEntity<PersonProfileDTO> getPerson(@PathVariable String email) {
        return ResponseEntity.ok(personService.getPerson(email));
    }

    @GetMapping("v1/{from}/{amount}")
    public ResponseEntity<List<PersonProfileDTO>> getPersonList(@PathVariable Integer amount, @PathVariable Integer from) {
        return ResponseEntity.ok( personService.getPersonList(from, amount) );
    }

    @DeleteMapping("v1/{email}")
    public ResponseEntity<PersonProfileDTO> deletePerson(@PathVariable String email) {
        return ResponseEntity.ok( personService.deletePerson(email) );
    }

    @PostMapping("v1/")
    public ResponseEntity<PersonProfileDTO> createPerson(@Valid @RequestBody PersonCreateDTO personCreateDTO) {
        return ResponseEntity.ok( personService.createPerson(personCreateDTO) );
    }

    @PutMapping("v1/{email}")
    public ResponseEntity<PersonProfileDTO> updatePerson(@PathVariable String email, @Valid @RequestBody PersonUpdateDTO personUpdateDTO) {
        return ResponseEntity.ok( personService.updatePerson(personUpdateDTO, email) );
    }

}