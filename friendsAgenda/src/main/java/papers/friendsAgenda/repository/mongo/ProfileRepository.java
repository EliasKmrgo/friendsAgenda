package papers.friendsAgenda.repository.mongo;

import org.springframework.stereotype.Repository;
import papers.friendsAgenda.domain.mongo.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {
    
}
