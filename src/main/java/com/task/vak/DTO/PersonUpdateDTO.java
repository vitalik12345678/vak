package com.task.vak.DTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PersonUpdateDTO  {

    @NotBlank(message = "name is mull or empty")
    @Length(max = 40)
    private String name;
    @Length(max = 40)
    @NotBlank(message = "surname is mull or empty")
    private String surname;
    @Email
    @Length(max = 40)
    private String email;
    @NotBlank(message = "phone is empty or null")
    @Length(max = 20)
    private String phone;
    @NotNull(message = "birthDate is mull or empty")
    private LocalDate birthDate;
    @Length(max = 40)
    @NotBlank(message = "username is mull or empty")
    private String username;
    @Length(max = 16)
    @NotBlank(message = "password is mull or empty")
    private String password;

}
