package papers.friendsAgenda.repository.neo4j;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import papers.friendsAgenda.domain.neo4j.EventGraph;

public interface EventGraphRepository extends Neo4jRepository<EventGraph, Integer>{
}
