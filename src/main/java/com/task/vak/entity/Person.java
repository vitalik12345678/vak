package com.task.vak.entity;

import com.task.vak.mapper.Convertable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person implements Convertable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String phone;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column
    private Integer age;

    @Column
    private String username;

    @Column
    private String password;
}
