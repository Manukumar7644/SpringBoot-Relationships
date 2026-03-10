package in.scalive.service;

import java.util.List;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.scalive.model.Dept;
import in.scalive.model.Emp;
import in.scalive.repository.DeptRepository;
import in.scalive.repository.EmpRepository;

@Service
public class EmpDeptService {
    private DeptRepository drepo;
    private EmpRepository  erepo;
    @Autowired
	public EmpDeptService(DeptRepository drepo, EmpRepository erepo) {
		
		this.drepo = drepo;
		this.erepo = erepo;
	}
    public void createDept(String deptName) {
    	Dept dept=new Dept(deptName);
    	drepo.save(dept);
    	System.out.println("Dept saved:"+deptName);
    }
//	public void addEmpToDept(Integer deptId,String ename) {
//		Dept dept=drepo.findById(deptId).orElse(null);
//		if(dept!=null) {
//			Emp emp=new Emp(ename);
//			dept.addEmp(emp);
//			drepo.save(dept);
//			System.out.println("Emp added:"+ename);
//		}else {
//			System.out.println("Dept not found!");
//		}
//	}
	public void addEmpToDept(Integer deptId,String ename) {
		Dept dept=drepo.findById(deptId).orElse(null);
		if(dept!=null) {
			Emp emp=new Emp(ename);
			emp.setDept(dept);
			erepo.save(emp);
			System.out.println("Emp added:"+ename);
		}else {
			System.out.println("Dept not found!");
		}
	}
	public void showAllDepts() {
		System.out.println("Dept and Emps");
		List<Dept>depList=drepo.findAll();
		for(Dept dept:depList) {
			System.out.println("Dept name:"+dept.getName());
			for(Emp emp:dept.getEmpList()) {
				System.out.println("-Emp:"+emp.getName());
			}
		}
	}

	public void deleteEmp(Integer empId) {
		Emp emp=erepo.findById(empId).orElse(null);
		if(emp==null) {
			System.out.println("Emp not found");
		}else {
			Dept dept=emp.getDept();
			if(dept!=null) {
				dept.removeEmp(emp);
				drepo.save(dept);//Link will break 
			}
			erepo.delete(emp);//delete emp
			System.out.println("Emp deleted!");
		}
	}
	public void updateEmpName(Integer empId,String newName) {
		Emp emp=erepo.findById(empId).orElse(null);
		if(emp==null) {
			System.out.println("Emp not found");
			return;
		}
		emp.setName(newName);
		erepo.save(emp);
		System.out.println("Employee name updated!");
	}
	public void updateDeptName(Integer deptId,String newName) {
		Dept dept=drepo.findById(deptId).orElse(null);
		if(dept!=null) {
			dept.setName(newName);
			drepo.save(dept);
			System.out.println("Dept Name changed");
		}else {
			System.out.println("Dept not found");
		}
	}
	public void deleteDept(Integer deptId) {
		Dept dept=drepo.findById(deptId).orElse(null);
		if(dept!=null) {
			drepo.delete(dept);
			System.out.println("Dept deleted");
		}else {
			System.out.println("Dept not found");
		}
	}
}
