package com.task.vak.service.impl;

import com.task.vak.DTO.PersonCreateDTO;
import com.task.vak.DTO.PersonFilteredDTO;
import com.task.vak.DTO.PersonProfileDTO;
import com.task.vak.DTO.PersonUpdateDTO;
import com.task.vak.entity.Person;
import com.task.vak.entity.mapper.DTOConvertor;
import com.task.vak.exceprion.ExistException;
import com.task.vak.exceprion.NotExistException;
import com.task.vak.repository.PersonRepository;
import com.task.vak.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class PersonServiceImpl implements PersonService {

    private static final String PERSON_NOT_EXIST = "person doesn't exist";
    private static final String PERSON_EXIST = "person exist";
    private final DTOConvertor dtoConvertor;
    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PersonServiceImpl(DTOConvertor dtoConvertor, PersonRepository personRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.dtoConvertor = dtoConvertor;
        this.personRepository = personRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public PersonProfileDTO createPerson(PersonCreateDTO personCreateDTO) {

        if (personRepository.existsByEmail(personCreateDTO.getEmail())) {
            throw new ExistException(PERSON_EXIST);
        }

        Person person = dtoConvertor.convertToEntity(personCreateDTO, new Person());
        person.setAge(LocalDate.now().getYear() - personCreateDTO.getBirthDate().getYear());
        person.setPassword(bCryptPasswordEncoder.encode(personCreateDTO.getPassword()));
        personRepository.save(person);
        return dtoConvertor.convertToDTO(person, new PersonProfileDTO());
    }

    @Override
    public List<PersonProfileDTO> getPersonList(Integer from, Integer amount) {
        return personRepository.findAll(PageRequest.of(from, amount)).getContent().stream().map(element -> dtoConvertor.convertToDTO(element, new PersonProfileDTO())).collect(Collectors.toList());
    }

    @Override
    public PersonProfileDTO deletePerson(String email) {
        Person person = findPerson(email);
        personRepository.delete(person);
        return dtoConvertor.convertToDTO(person, new PersonProfileDTO());
    }

    @Override
    public PersonProfileDTO getPerson(String email) {
        return dtoConvertor.convertToDTO(findPerson(email), new PersonProfileDTO());
    }

    @Override
    public PersonProfileDTO updatePerson(PersonUpdateDTO personUpdateDTO, String email) {

        if (!personRepository.existsByEmail(email)) {
            throw new NotExistException(PERSON_NOT_EXIST);
        }

        Person updatedPerson = dtoConvertor.convertToEntity(personUpdateDTO, new Person());
        updatedPerson.setAge(LocalDate.now().getYear() - personUpdateDTO.getBirthDate().getYear());
        updatedPerson.setPassword(bCryptPasswordEncoder.encode(updatedPerson.getPassword()));
        personRepository.save(updatedPerson);

        return dtoConvertor.convertToDTO(updatedPerson, new PersonProfileDTO());
    }

    @Override
    public List<PersonFilteredDTO> getFilteredPersons(String name, Integer age) {
        return personRepository.filteredByAgeAndEmail(name, age).stream().map(element -> dtoConvertor.convertToDTO(element, new PersonFilteredDTO())).collect(Collectors.toList());
    }

    private Person findPerson(String email) {
        return personRepository.findByEmail(email).orElseThrow(() -> {
            throw new NotExistException(PERSON_NOT_EXIST);
        });
    }
}
