package br.com.murielmagno.personapi.utils;

import br.com.murielmagno.personapi.dto.request.PersonDTO;
import br.com.murielmagno.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .nome(FIRST_NAME)
                .sobrenome(LAST_NAME)
                .cpf(CPF_NUMBER)
                .dataNascimento("04-04-2010")
                .telefones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .nome(FIRST_NAME)
                .sobrenome(LAST_NAME)
                .cpf(CPF_NUMBER)
                .dataNascimento(BIRTH_DATE)
                .telefones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
