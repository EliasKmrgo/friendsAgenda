package papers.friendsAgenda.domain.neo4j;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Friendship {

    @Id @GeneratedValue
    private Long id;

    private String since; // fecha en formato ISO (yyyy-MM-dd)

    @TargetNode
    private PersonGraph friend;

    public Friendship() {}

    public Friendship(String since, PersonGraph friend) {
        this.since = since;
        this.friend = friend;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSince() { return since; }
    public void setSince(String since) { this.since = since; }

    public PersonGraph getFriend() { return friend; }
    public void setFriend(PersonGraph friend) { this.friend = friend; }
}
