package com.task.vak.service;

import com.task.vak.DTO.PersonCreateRequest;
import com.task.vak.DTO.PersonFilteredResponse;
import com.task.vak.DTO.PersonProfileResponse;
import com.task.vak.DTO.PersonUpdateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    ResponseEntity<PersonProfileResponse> createPerson(PersonCreateRequest personCreateRequest);

    ResponseEntity<List<PersonProfileResponse>> getPersonList(Integer from, Integer amount);

    ResponseEntity<PersonProfileResponse> deletePerson(String email);

    ResponseEntity<PersonProfileResponse> getPerson(String email);

    ResponseEntity<PersonProfileResponse> updatePerson(PersonUpdateRequest personUpdateRequest,String email);

    ResponseEntity<List<PersonFilteredResponse>> getFilteredPersons(String name, Integer age);
}
