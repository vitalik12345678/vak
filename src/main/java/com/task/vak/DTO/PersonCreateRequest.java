package com.task.vak.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PersonCreateRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotNull
    private LocalDate birthDate;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
