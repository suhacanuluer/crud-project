package com.example.crudproject.repository;

import com.example.crudproject.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query(
            nativeQuery = true,
            value = "select * from person p where p.city = :city"
    )
    List<PersonEntity> findByCity(@Param("city") String city);
}
