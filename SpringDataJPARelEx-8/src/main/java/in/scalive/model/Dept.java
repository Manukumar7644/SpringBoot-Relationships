package in.scalive.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval = true)
	
	private List<Emp>empList=new ArrayList<>();
	public Dept() {
		
	}
	public Dept(String name) {
		this.name=name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	public void addEmp(Emp e) {
		this.empList.add(e);
		e.setDept(this);//set the back ref
	}
	public void removeEmp(Emp e) {
		this.empList.remove(e);
		e.setDept(null);//clear the back ref
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", empList=" + empList + "]";
	}
	
}
