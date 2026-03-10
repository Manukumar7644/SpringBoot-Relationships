package in.scalive.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.model.Profile;
import in.scalive.repository.ProfileRepository;
@Service
public class ProfileService {
	private ProfileRepository repo;
    @Autowired
	public ProfileService(ProfileRepository repo) {
		this.repo = repo;
	}
    public Optional<Profile>getProfileById(Integer id){
    	return repo.findById(id);
    }
}
