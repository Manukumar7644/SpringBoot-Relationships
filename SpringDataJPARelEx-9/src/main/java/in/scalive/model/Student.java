package in.scalive.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer id;
   private String name;
   
   @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinTable(name="student_course",joinColumns = @JoinColumn(name="student_id"),
   inverseJoinColumns = @JoinColumn(name="course_id"))
   private Set<Course> courses=new HashSet<>();

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

public Set<Course> getCourses() {
	return courses;
}

public void setCourses(Set<Course> courses) {
	this.courses = courses;
}
   
}
