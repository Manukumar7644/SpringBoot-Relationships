package in.scalive.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.model.Dept;
import in.scalive.model.Emp;
import in.scalive.service.DeptService;

@Component
public class MyCommandLineRunner implements CommandLineRunner{
    @Autowired
	private DeptService deptServ;
        
	@Override
	public void run(String... args) throws Exception {
		List<String>nameList=List.of("Neeraj","Dheeraj");
		Dept dept1=deptServ.createDepartmentWithEmp("IT", nameList);
    	System.out.println("Department created:"+dept1.getName());
    	deptServ.getAllDepartments();
    	
	}
	

}
