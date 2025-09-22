package papers.friendsAgenda.controller;

import org.springframework.web.bind.annotation.*;

import papers.friendsAgenda.domain.sql.Person;
import papers.friendsAgenda.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // GET /persons -> lista todas las personas
    @GetMapping
    public List<Person> getAll() {
        return personService.buscarTodos();
    }

    // GET /persons/{id} -> buscar por id
    @GetMapping("/{id}")
    public Person getById(@PathVariable Integer id) {
        return personService.buscarPorId(id);
    }

    // GET /persons/email/{email} -> buscar por email
    @GetMapping("/email/{email}")
    public Person getByEmail(@PathVariable String email) {
        return personService.buscarPorEmail(email);
    }

    // GET /persons/search?name=Juan -> buscar por nombre
    @GetMapping("/search")
    public List<Person> searchByName(@RequestParam String name) {
        return personService.buscarPorNombre(name);
    }

    // POST /persons -> crear nueva persona
    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.guardar(person);
    }

    // PUT /persons/{id} -> actualizar persona existente
    @PutMapping("/{id}")
    public Person update(@PathVariable Integer id, @RequestBody Person person) {
        Person existing = personService.buscarPorId(id);
        if (existing != null) {
            person.setPersonId(id); // aseguro que se actualice la misma
            return personService.guardar(person);
        }
        return null; // o lanzar excepción con ResponseStatus
    }

    // DELETE /persons/{id} -> eliminar persona
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        personService.eliminar(id);
    }
}
