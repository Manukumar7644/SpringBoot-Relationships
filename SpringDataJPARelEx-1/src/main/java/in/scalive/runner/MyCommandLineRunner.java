package in.scalive.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.model.Profile;
import in.scalive.model.User;
import in.scalive.service.UserService;

@Component
public class MyCommandLineRunner implements CommandLineRunner{
    @Autowired
	private UserService serv;
	@Override
	public void run(String... args) throws Exception {
		User user=serv.createUserWithProfile("Amit","SDE-1");
		System.out.println("User created with:"+user.getId());
		Optional<User>result= serv.findById(user.getId());
		if(result.isPresent()) {
			User searchedUser=result.get();
			System.out.println("Name:"+searchedUser.getName());
			Profile profile=searchedUser.getProfile();
			System.out.println("Bio:"+profile.getBio());
		}else {
			System.out.println("User not found!");
		}
	}

}
