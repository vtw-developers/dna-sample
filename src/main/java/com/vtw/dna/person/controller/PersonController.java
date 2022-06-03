package com.vtw.dna.person.controller;

import com.vtw.dna.person.Person;
import com.vtw.dna.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Seungmin.bang
 * @version : 1.0.0
 * @package : com.vtw.dna.person.repository
 * @name : PersonController.java
 * @date : 2022-06-02
 * @modifyed : Person Controller
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;

    @PostMapping
    public Person find(@RequestBody String id) {
        Person person = repository.findById(id).get();
        System.out.println(person.toString());
        return person;
    }
}