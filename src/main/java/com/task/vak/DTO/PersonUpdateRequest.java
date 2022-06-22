package com.task.vak.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PersonUpdateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String phone;
    @NotNull
    private LocalDate birthDate;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
