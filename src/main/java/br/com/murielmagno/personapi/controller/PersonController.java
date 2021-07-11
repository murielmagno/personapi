package br.com.murielmagno.personapi.controller;

import br.com.murielmagno.personapi.dto.MessageResponseDTO;
import br.com.murielmagno.personapi.entity.Person;
import br.com.murielmagno.personapi.repository.PersonRepository;
import br.com.murielmagno.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
