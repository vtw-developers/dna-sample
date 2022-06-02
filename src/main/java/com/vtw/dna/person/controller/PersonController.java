package com.vtw.dna.person.controller;

import com.vtw.dna.person.Person;
import com.vtw.dna.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
* @package : com.vtw.dna.person.repository
* @name : PersonController.java
* @date : 2022-06-02
* @author : Seungmin.bang
* @version : 1.0.0
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
        return person;
    }
}