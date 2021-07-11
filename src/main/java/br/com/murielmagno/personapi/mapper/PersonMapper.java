package br.com.murielmagno.personapi.mapper;

import br.com.murielmagno.personapi.dto.request.PersonDTO;
import br.com.murielmagno.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "dataNascimento", source = "dataNascimento",dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);

}