package com.example.crudproject.entity;

import com.example.crudproject.dto.PersonDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class PersonEntity {

    public PersonEntity(String name, String surname, int age, String city, Boolean isStudent) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.isStudent = isStudent;
    }

    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String city;
    private Boolean isStudent;
    
    public static PersonEntity of(PersonDto personDto) {
        return new PersonEntity(personDto.getName(),
                personDto.getSurname(),
                personDto.getAge(),
                personDto.getCity(),
                personDto.getIsStudent());
    }

}
