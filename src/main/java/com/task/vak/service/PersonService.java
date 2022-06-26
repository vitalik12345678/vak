package com.task.vak.service;

import com.task.vak.DTO.PersonCreateDTO;
import com.task.vak.DTO.PersonFilteredDTO;
import com.task.vak.DTO.PersonProfileDTO;
import com.task.vak.DTO.PersonUpdateDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    PersonProfileDTO createPerson(PersonCreateDTO personCreateDTO);

    List<PersonProfileDTO> findAll(Pageable pageable);

    PersonProfileDTO deletePerson(String email);

    PersonProfileDTO getPerson(String email);

    PersonProfileDTO updatePerson(PersonUpdateDTO personUpdateDTO, String email);

    List<PersonFilteredDTO> getFilteredPersons(String name, Integer age);
}
