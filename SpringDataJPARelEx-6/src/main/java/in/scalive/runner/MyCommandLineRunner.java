package in.scalive.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.model.Dept;
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
    	nameList=List.of("Riya","Priya");
		Dept dept2=deptServ.createDepartmentWithEmp("HR", nameList);
    	System.out.println("Department created:"+dept2.getName());
    	
    	Dept upDept=deptServ.updateDeptName(2, "Finance");
    	if(upDept== null) {
    		System.out.println("Dept not found!");
    	}else {
    		System.out.println("Dept updated:"+upDept.getName());
    	}
    	deptServ.addEmpToDept(1, "Mayank");
    	List<Dept> deptList=deptServ.getAllDepartments();
    	for(Dept d:deptList) {
    		System.out.println(d);
    	}
    	deptServ.removeEmpFromDept(1, 5);
    	System.out.println("After removing:");
    	deptList=deptServ.getAllDepartments();
    	for(Dept d:deptList) {
    		System.out.println(d);
    	}
    	deptServ.deleteDept(1);
	}
	

}
