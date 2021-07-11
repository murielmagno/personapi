package br.com.murielmagno.personapi.service;

import br.com.murielmagno.personapi.dto.request.PersonDTO;
import br.com.murielmagno.personapi.dto.response.MessageResponseDTO;
import br.com.murielmagno.personapi.entity.Person;
import br.com.murielmagno.personapi.exception.PersonNotFoundException;
import br.com.murielmagno.personapi.mapper.PersonMapper;
import br.com.murielmagno.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return createdMessageResponse(savedPerson.getId(), "Pessoa criada com o ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPerson = personRepository.findAll();
        return allPerson.stream().map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findByid(Long id) throws PersonNotFoundException {
        Person person = verifyIfExist(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExist(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExist(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);
        return createdMessageResponse(updatedPerson.getId(), "Pessoa atualizada com o ID ");
    }

    private Person verifyIfExist(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createdMessageResponse(Long id, String message) {
        return MessageResponseDTO.builder().message(message + id).build();
    }
}
