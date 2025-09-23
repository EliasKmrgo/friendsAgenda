package papers.friendsAgenda.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import papers.friendsAgenda.domain.mongo.Profile;
import papers.friendsAgenda.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // GET /profiles
    @GetMapping
    public List<Profile> getAll() {
        return profileService.getAllProfiles();
    }

    // GET /profiles/{id}
    @GetMapping("/{id}")
    public Optional<Profile> getById(@PathVariable String id) {
        return profileService.getProfileById(id);
    }

    // POST /profiles
    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.saveProfile(profile);
    }

    // PUT /profiles/{id}
    @PutMapping("/{id}")
    public Profile updateProfile(@PathVariable String id, @RequestBody Profile profile) {
        Optional<Profile> existing = profileService.getProfileById(id);
        if (existing.isPresent()) {
            profile.setId(id); 
            return profileService.saveProfile(profile);
        }
        return null;
    }

    // DELETE /profiles/{id}
    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable String id) {
        profileService.deleteProfile(id);
    }
}
