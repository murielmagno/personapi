package br.com.murielmagno.personapi.service;

import br.com.murielmagno.personapi.dto.request.PersonDTO;
import br.com.murielmagno.personapi.dto.response.MessageResponseDTO;
import br.com.murielmagno.personapi.entity.Person;
import br.com.murielmagno.personapi.exception.PersonNotFoundException;
import br.com.murielmagno.personapi.mapper.PersonMapper;
import br.com.murielmagno.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Pessoa criada com o ID " + savedPerson.getId()).build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPerson = personRepository.findAll();
        return allPerson.stream().map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findByid(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }
}
