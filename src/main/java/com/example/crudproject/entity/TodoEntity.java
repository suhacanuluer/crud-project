package com.example.crudproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class TodoEntity {

    @Id
    @SequenceGenerator(name = "seq_person_todo", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_todo", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String content;
    private Boolean isCompleted = Boolean.FALSE;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="person_id")
    private PersonEntity person;
}
