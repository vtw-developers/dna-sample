package com.vtw.dna.person.repository;

import com.vtw.dna.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @package : com.vtw.dna.person.repository
* @name : PersonRepository.java
* @date : 2022-06-02
* @author : Seungmin.bang
* @version : 1.0.0
* @modifyed : Person Repository
**/
public interface PersonRepository extends JpaRepository<Person, String> {

}
