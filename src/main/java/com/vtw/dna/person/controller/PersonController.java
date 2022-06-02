package com.vtw.dna.person.controller;

import com.vtw.dna.person.Person;
import com.vtw.dna.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;

//    @GetMapping("/{id}")
    @PostMapping
//    public Person find(@PathVariable String id) {
    public Person find(@RequestBody String id) {
        Person person = repository.findById(id).get();
        System.out.println(person.toString());
        return person;
    }

}
