package com.vtw.dna.person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
* @package : com.vtw.dna.person
* @name : Person.java
* @date : 2022-06-02
* @author : Seungmin.bang
* @version : 1.0.0
* @modifyed : Person Entity (JPA 사용)
**/
@Entity
@NoArgsConstructor
public class Person {

    @Id
    private String id;
    private String name;
    private Gender gender;
    private String job;
    private int salary;

}
