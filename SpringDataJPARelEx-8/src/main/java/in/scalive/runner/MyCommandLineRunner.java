package in.scalive.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.model.Dept;
import in.scalive.model.Emp;
import in.scalive.service.EmpDeptService;

@Component
public class MyCommandLineRunner implements CommandLineRunner{
    @Autowired
	private EmpDeptService edServ;
        
	@Override
	public void run(String... args) throws Exception {
		edServ.createDept("IT");
    	edServ.addEmpToDept(1, "Mayank");
    	edServ.addEmpToDept(1, "Dheeraj");
    	edServ.createDept("HR");
    	edServ.addEmpToDept(2, "Jitesh");
    	edServ.addEmpToDept(2, "Mahesh");
    	edServ.showAllDepts();
    	edServ.deleteDept(1);
    	edServ.showAllDepts();
    	
    	
	}
	

}
