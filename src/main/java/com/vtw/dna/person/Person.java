package com.vtw.dna.person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Person {

    @Id
    private String id;
    private String name;
    private Gender gender;
    private String job;
    private int salary;

}
