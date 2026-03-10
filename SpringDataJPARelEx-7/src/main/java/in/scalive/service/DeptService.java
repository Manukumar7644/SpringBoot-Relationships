package in.scalive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.scalive.model.Dept;
import in.scalive.model.Emp;
import in.scalive.repository.DeptRepository;

@Service
public class DeptService {
    private DeptRepository repo;

	@Autowired
    public DeptService(DeptRepository repo) {
		this.repo = repo;
	}
	public Dept createDepartmentWithEmp(String dname,List<String>empNameList) {
		Dept dept=new Dept(dname);
		for(String name:empNameList) {
		  Emp emp=new Emp(name);
		  dept.addEmp(emp);
		}
		return repo.save(dept);
	}
	@Transactional
    public void getAllDepartments(){
    	List<Dept>deptList=repo.findAll();
    	for(Dept d:deptList) {
    		System.out.println("dept name:"+d.getName());
    		List<Emp>empList=d.getEmpList();
    		for(Emp e:empList) {
    			System.out.println(e);
    		}
    	}
    }
    public Dept updateDeptName(Integer deptId,String dname) {
    	Optional<Dept> result=repo.findById(deptId);
    	if(result.isEmpty()) {
    		return null;
    	}
    	Dept dept=result.get();
    	dept.setName(dname);
    	return repo.save(dept);
    }
    public void addEmpToDept(Integer deptId,String ename) {
    	Optional<Dept> result=repo.findById(deptId);
    	if(result.isEmpty()) {
    		System.out.println("Dept not found");
    		return;
    	}
    	Dept dept=result.get();
    	Emp e=new Emp(ename);
    	dept.addEmp(e);
    	repo.save(dept);
    }
    public void removeEmpFromDept(Integer deptId,Integer empId) {
    	Optional<Dept> result=repo.findById(deptId);
    	if(result.isEmpty()) {
    		System.out.println("Dept not found");
    		return;
    	}
    	Dept dept=result.get();
    	List<Emp>empList=dept.getEmpList();
    	for(Emp e:empList) {
    		if(e.getId()==empId) {
    			dept.removeEmp(e);
    			repo.save(dept);
    			System.out.println("Emp removed!");
    			return;
    		}
    	}
    	System.out.println("Emp not found!");
    }
    public void deleteDept(Integer deptId) {
    	Optional<Dept> result=repo.findById(deptId);
    	if(result.isEmpty()) {
    		System.out.println("Dept not found");
    		return;
    	}
    	repo.deleteById(deptId);
    	System.out.println("Dept deleted");
    }
}
