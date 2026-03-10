package in.scalive.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.model.Profile;
import in.scalive.model.User;
import in.scalive.service.ProfileService;
import in.scalive.service.UserService;

@Component
public class MyCommandLineRunner implements CommandLineRunner{
    @Autowired
	private UserService userServ;
    @Autowired
    private ProfileService profServ;
	@Override
	public void run(String... args) throws Exception {
		Optional<User>result1=userServ.getUserById(1);
		if(result1.isPresent()) {
		  System.out.println("Fetching data from user..");
		  User user=result1.get();
		  System.out.println("Userid:"+user.getId());
		  System.out.println("Username:"+user.getName());
		  System.out.println("User's profile:"+user.getProfile().getBio());
		}else {
			System.out.println("User not found");
		}
		Optional<Profile>result2=profServ.getProfileById(1);
		if(result2.isPresent()) {
		  System.out.println("Fetching data from profile..");
		  Profile profile=result2.get();
		  System.out.println("Profile id:"+profile.getId());
		  System.out.println("Bio:"+profile.getBio());
		  System.out.println("User's name:"+profile.getUser().getName());
		}else {
			System.out.println("Profile not found");
		}
	}

}
