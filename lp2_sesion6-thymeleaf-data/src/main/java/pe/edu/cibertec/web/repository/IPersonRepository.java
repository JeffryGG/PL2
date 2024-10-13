package pe.edu.cibertec.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.web.model.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer>{

}
