package in.scalive.service;

import java.util.Optional;

import org.hibernate.metamodel.internal.AbstractEntityInstantiatorPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.model.Profile;
import in.scalive.model.User;
import in.scalive.repository.UserRepository;

@Service
public class UserService {
	private UserRepository repo;
    @Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
    public User createUserWithProfile(String name,String bio) {
    	User user=new User(name);
    	Profile profile=new Profile(bio);
    	user.setProfile(profile);
    	return repo.save(user);
    	
    }
    public Optional<User>getUserById(Integer id){
    	return repo.findById(id);
    }
    public boolean updateUserNameAndBio(Integer userId,String newName,String newBio) {
    	Optional<User>result=repo.findById(userId);
    	if(!result.isPresent()) {
    		return false;
    	}
    	User user=result.get();
    	user.setName(newName);
    	user.getProfile().setBio(newBio);
    	repo.save(user);
    	return true;
    }
}
