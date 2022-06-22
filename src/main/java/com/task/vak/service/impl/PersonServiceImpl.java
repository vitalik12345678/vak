package com.task.vak.service.impl;

import com.task.vak.DTO.PersonCreateRequest;
import com.task.vak.DTO.PersonProfileResponse;
import com.task.vak.DTO.PersonUpdateRequest;
import com.task.vak.entity.Person;
import com.task.vak.entity.mapper.DTOConvertor;
import com.task.vak.exceprion.ExistException;
import com.task.vak.exceprion.NotExistException;
import com.task.vak.repository.PersonRepository;
import com.task.vak.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final DTOConvertor dtoConvertor;
    private final PersonRepository personRepository;
    private final static String PERSON_NOT_EXIST = "person doesn't exist";
    private final static String PERSON_EXIST = "person exist";

    @Autowired
    public PersonServiceImpl(DTOConvertor dtoConvertor, PersonRepository personRepository) {
        this.dtoConvertor = dtoConvertor;
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<PersonProfileResponse> createPerson(PersonCreateRequest personCreateRequest) {
        Person person = personRepository.findByEmail(personCreateRequest.getEmail()).orElseThrow(() -> {
            throw new ExistException(PERSON_EXIST);
        });
        person = dtoConvertor.convertToEntity(personCreateRequest, new Person());
        person.setAge(LocalDate.now().getYear() - personCreateRequest.getBirthDate().getYear());
        personRepository.save(person);
        return ResponseEntity.ok(dtoConvertor.convertToDTO(person, new PersonProfileResponse()));
    }

    @Override
    public ResponseEntity<List<PersonProfileResponse>> getPersonList(Integer from, Integer amount) {
        Page<Person> list = personRepository.findAll(PageRequest.of(from, amount));
        return ResponseEntity.ok(list.getContent().stream().map(element -> dtoConvertor.convertToDTO(element, new PersonProfileResponse())).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<PersonProfileResponse> deletePerson(String email) {
        Person person = findPersonByEmail(email);
        personRepository.delete(person);
        return ResponseEntity.ok(dtoConvertor.convertToDTO(person, new PersonProfileResponse()));
    }

    @Override
    public ResponseEntity<PersonProfileResponse> getPerson(String email) {
        return ResponseEntity.ok(dtoConvertor.convertToDTO(findPersonByEmail(email), new PersonProfileResponse()));
    }

    @Override
    public ResponseEntity<PersonProfileResponse> updatePerson(PersonUpdateRequest personUpdateRequest, String email) {

        Person existPerson = findPersonByEmail(email);
        existPerson = dtoConvertor.convertToEntity(personUpdateRequest, new Person());
        existPerson.setAge(LocalDate.now().getYear() - personUpdateRequest.getBirthDate().getYear());

        return ResponseEntity.ok(dtoConvertor.convertToDTO(existPerson, new PersonProfileResponse()));
    }

    private Person findPersonByEmail(String email) {
        return personRepository.findByEmail(email).orElseThrow(() -> {
            throw new NotExistException(PERSON_NOT_EXIST);
        });
    }
}