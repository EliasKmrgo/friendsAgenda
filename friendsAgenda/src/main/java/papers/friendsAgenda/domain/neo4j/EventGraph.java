package papers.friendsAgenda.domain.neo4j;

import org.springframework.data.neo4j.core.schema.*;

@Node("EventGraph")
public class EventGraph {

    @Id
    private Integer id;

    private String name;

    // Constructor
    public EventGraph(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
