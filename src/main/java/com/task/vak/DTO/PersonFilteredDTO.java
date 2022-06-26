package com.task.vak.DTO;

import com.task.vak.mapper.Convertable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonFilteredDTO implements Convertable {

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String username;
    private String password;
    private LocalDate birthDate;
    private Integer age;

}
