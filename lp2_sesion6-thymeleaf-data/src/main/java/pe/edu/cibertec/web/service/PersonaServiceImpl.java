package pe.edu.cibertec.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.web.model.Person;
import pe.edu.cibertec.web.repository.IPersonRepository;

@Service
public class PersonaServiceImpl implements PersonService {

	@Autowired
	private IPersonRepository personRepository;
	
	@Override
    public List<Person> findAll() {
        return (List<Person>)  personRepository.findAll();
    }

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person findById(Integer id) {
		return personRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		personRepository.deleteById(id);
		
	}
}
