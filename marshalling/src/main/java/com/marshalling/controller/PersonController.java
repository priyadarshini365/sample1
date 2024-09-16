package com.marshalling.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marshalling.entity.Person;
import com.marshalling.service.PersonService;

import jakarta.xml.bind.JAXBException;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public String createPersonXml(@RequestBody String personXml) throws JAXBException {
        Person person = personService.unmarshalPerson(personXml);
        personService.savePerson(person);
        return personService.marshalPerson(person);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public String getPersonXml(@PathVariable Long id) throws JAXBException {
        Person person = personService.getPerson(id);
        if (person != null) {
            return personService.marshalPerson(person);
        } else {
            return "<error>Person not found</error>";
        }
    }
}