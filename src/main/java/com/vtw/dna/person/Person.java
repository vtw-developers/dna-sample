package com.vtw.dna.person;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : Seungmin.bang
 * @version : 1.0.0
 * @package : com.vtw.dna.person
 * @name : Person.java
 * @date : 2022-06-02
 * @modifyed : Person Entity (JPA 사용)
 **/
@Entity
@Getter
@NoArgsConstructor
public class Person {

    @Id
    private String id;
    private String name;
    private Gender gender;
    private String job;
    private int salary;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ", \"name\":\"" + name + "\"" +
                ", \"gender\":\"" + gender + "\"" +
                ", \"job\":\"" + job + "\"" +
                ", \"salary\":" + salary +
                '}';
    }
}
