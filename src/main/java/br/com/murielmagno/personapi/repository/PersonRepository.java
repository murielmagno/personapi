package br.com.murielmagno.personapi.repository;

import br.com.murielmagno.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
