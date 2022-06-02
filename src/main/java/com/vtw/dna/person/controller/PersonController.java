package com.vtw.dna.person.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtw.dna.person.Person;
import com.vtw.dna.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public String find(@RequestBody String id) {
        Person person = repository.findById(id).get();
        System.out.println(person.toString());
        return person.toString();
    }
}