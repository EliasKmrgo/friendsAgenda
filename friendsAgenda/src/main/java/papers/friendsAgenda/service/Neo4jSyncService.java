package papers.friendsAgenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import papers.friendsAgenda.domain.neo4j.PersonGraph;
import papers.friendsAgenda.domain.sql.Person;
import papers.friendsAgenda.repository.neo4j.PersonGraphRepository;
import papers.friendsAgenda.repository.sql.PersonRepository;

@Service
public class Neo4jSyncService {

    @Autowired
    private PersonRepository personRepo;          // SQL
    @Autowired
    private PersonGraphRepository personGraphRepo; // Neo4j

    // Constructor o método para poblar datos iniciales
    public void createSamplePerson() {
        personRepo.save(new Person("selene123", "Selene Daza", 25, "selene@example.com"));
    }

    public void syncPersonsToNeo4j() {
        List<Person> persons = personRepo.findAll(); // Trae todos de SQL

        for (Person p : persons) {
            PersonGraph pg = new PersonGraph(p.getPersonId(), p.getUserName());
            personGraphRepo.save(pg); // Guarda en Neo4j
        }
    }
}
