package com.marshalling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marshalling.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
