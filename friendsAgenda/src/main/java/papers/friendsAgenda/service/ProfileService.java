package papers.friendsAgenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import papers.friendsAgenda.domain.mongo.Profile;
import papers.friendsAgenda.repository.mongo.ProfileRepository;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(String id) {
        return profileRepository.findById(id);
    }

    public void deleteProfile(String id) {
        profileRepository.deleteById(id);
    }
}
