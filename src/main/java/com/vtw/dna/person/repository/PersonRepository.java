package com.vtw.dna.person.repository;

import com.vtw.dna.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {

}
