package br.com.murielmagno.personapi.service;

import br.com.murielmagno.personapi.dto.request.PersonDTO;
import br.com.murielmagno.personapi.dto.response.MessageResponseDTO;
import br.com.murielmagno.personapi.entity.Person;
import br.com.murielmagno.personapi.repository.PersonRepository;
import br.com.murielmagno.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.murielmagno.personapi.utils.PersonUtils.createFakeEntity;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testCriarDTOMessageSucesso(){
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();
        Mockito.when(personRepository.save(expectedSavedPerson)).thenReturn(expectedSavedPerson);
        MessageResponseDTO expectedSucessMessage = createExpectedMessage(expectedSavedPerson.getId());
        MessageResponseDTO sucessMessage = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSucessMessage,sucessMessage);
    }

    private MessageResponseDTO createExpectedMessage(Long id) {
        return MessageResponseDTO.builder()
                .message("Pessoa criada com o ID " + id).build();
    }

}
