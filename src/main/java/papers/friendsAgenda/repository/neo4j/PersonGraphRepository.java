package papers.friendsAgenda.repository.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import papers.friendsAgenda.domain.neo4j.PersonGraph;

public interface PersonGraphRepository extends Neo4jRepository<PersonGraph, Integer> {
    // No necesitas escribir nada más aquí.
    // Ya tienes métodos CRUD automáticos: save(), findAll(), findById(), delete(), etc.
}
