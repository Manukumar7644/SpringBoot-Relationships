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
	private UserService userServ;
        
	@Override
	public void run(String... args) throws Exception {
		
    	boolean result=userServ.createNewProfileAndUpdateUser(1, "Gen Ai Dev");
    	if(result) {
    		System.out.println("User Updated");
    		Optional<User>result1=userServ.getUserById(1);
    		User user=result1.get();
    		System.out.println("Id:"+user.getId());
    		System.out.println("Name:"+user.getName());
    		System.out.println("Bio:"+user.getProfile().getBio());
    	}else {
    		System.out.println("Rec not updated");
    	}
		
	}

}
