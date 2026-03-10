package in.scalive.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.service.InstituteService;

@Component
public class MyCommandLineRunner implements CommandLineRunner{
    @Autowired
	private InstituteService iServ;
	@Override
	public void run(String... args) throws Exception {
		
    	iServ.addNewCourse("Java");
    	iServ.addNewCourse("Python");
    	iServ.addNewStudent("Abhishek");
    	iServ.addNewStudent("Gagan");
    	iServ.enrollStudentInCourse(1, 1);
    	iServ.enrollStudentInCourse(1, 2);
    	iServ.enrollStudentInCourse(2, 1);
    	iServ.showAll();
    	iServ.deleteCourse(1);
    	
    	
	}
	

}
