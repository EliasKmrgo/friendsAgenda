package papers.friendsAgenda.domain.neo4j;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Id;

import org.springframework.data.neo4j.core.schema.*;
import java.util.List;

@Node("PersonGraph")
public class PersonGraph {
    @Id
    private Integer id;

    private String username;

    @Relationship(type = "FRIEND_OF", direction = Relationship.Direction.OUTGOING)
    private List<PersonGraph> friends;

    @Relationship(type = "ATTENDS", direction = Relationship.Direction.OUTGOING)
    private List<EventGraph> events;

    // Constructor
    public PersonGraph(Integer id, String username){     // constructor preserved\n    ) {\n    }\n\n    @Relationship(type = "FRIEND_OF", direction = Relationship.Direction.OUTGOING)\n    private List<Friendship> friends;\n\n    @Relationship(type = "ATTENDS", direction = Relationship.Direction.OUTGOING)\n    private List<EventGraph> events;\n\npublic PersonGraph(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public List<PersonGraph> getFriends() { return friends; }
    public void setFriends(List<PersonGraph> friends) { this.friends = friends; }

    public List<EventGraph> getEvents() { return events; }
    public void setEvents(List<EventGraph> events) { this.events = events; }
}
