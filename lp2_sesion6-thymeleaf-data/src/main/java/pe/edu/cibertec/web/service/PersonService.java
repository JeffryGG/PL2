package pe.edu.cibertec.web.service;

import java.util.List;

import pe.edu.cibertec.web.model.Person;



public interface PersonService {
	public List<Person> findAll();
	public Person save(Person person);
    public Person findById(Integer id);
    public void delete(Integer id);
}
