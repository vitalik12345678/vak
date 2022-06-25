package com.task.vak.repository;

import com.task.vak.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    Optional<Person> findByEmail(String email);

    @Query("select p from Person p where (:name is null or p.name =:name) and (:age is null or p.age =:age)")
    List<Person> filteredByAgeAndEmail(@Param("name")String name,@Param("age")Integer age);

    boolean existsByEmail(String email);
}
