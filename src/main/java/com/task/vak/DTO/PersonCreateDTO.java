package com.task.vak.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PersonCreateDTO {

    @NotBlank(message = "name is mull or empty")
    private String name;
    @NotBlank(message = "surname is mull or empty")
    private String surname;
    @Email
    private String email;
    @NotBlank(message = "phone is empty or null")
    private String phone;
    @NotNull(message = "birthDate is mull or empty")
    private LocalDate birthDate;
    @NotBlank(message = "username is mull or empty")
    private String username;
    @NotBlank(message = "password is mull or empty")
    private String password;

}
