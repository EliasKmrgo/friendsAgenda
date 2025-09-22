package papers.friendsAgenda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import papers.friendsAgenda.domain.sql.Person;
import papers.friendsAgenda.repository.sql.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> buscarTodos() {
        return personRepository.buscarTodos();
    }

    public Person buscarPorId(Integer id) {
        return personRepository.buscarPorId(id);
    }

    public Person buscarPorEmail(String email) {
        return personRepository.buscarPorEmail(email);
    }

    public List<Person> buscarPorNombre(String name) {
        return personRepository.buscarPorNombre(name);
    }

    public Person guardar(Person person) {
        return personRepository.save(person);
    }

    public void eliminar(Long id) {
        personRepository.deleteById(id);
    }
}
