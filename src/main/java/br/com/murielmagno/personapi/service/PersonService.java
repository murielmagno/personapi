package br.com.murielmagno.personapi.service;

import br.com.murielmagno.personapi.dto.MessageResponseDTO;
import br.com.murielmagno.personapi.entity.Person;
import br.com.murielmagno.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder().message("Pessoa criada com o ID "+savedPerson.getId()).build();
    }
}
