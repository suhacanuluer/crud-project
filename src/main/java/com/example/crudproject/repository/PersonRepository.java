package com.example.crudproject.repository;

import com.example.crudproject.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    //@Query("")
    PersonEntity findByIsStudent(Boolean isStudent);
}
