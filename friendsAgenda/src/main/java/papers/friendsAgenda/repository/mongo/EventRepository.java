package papers.friendsAgenda.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import papers.friendsAgenda.domain.mongo.EventDetail;

@Repository
public interface EventRepository  extends MongoRepository<EventDetail, String> {

}
