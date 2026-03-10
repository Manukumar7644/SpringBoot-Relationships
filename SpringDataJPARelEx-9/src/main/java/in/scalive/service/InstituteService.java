
package in.scalive.service;

import org.hibernate.sql.exec.internal.JdbcCallFunctionReturnImpl.RefCurserJdbcCallFunctionReturnImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.model.Course;
import in.scalive.model.Student;
import in.scalive.repository.CourseRepository;
import in.scalive.repository.StudentRepository;
@Service
public class InstituteService {
	private StudentRepository sRepo;
	private CourseRepository cRepo;
    @Autowired
	public InstituteService(StudentRepository sRepo, CourseRepository cRepo) {
		
		this.sRepo = sRepo;
		this.cRepo = cRepo;
	}
    public void addNewCourse(String title) {
    	Course c=new Course();
    	c.setTitle(title);
    	cRepo.save(c);
    	System.out.println("Course Saved:"+c.getTitle());
    }
    public void addNewStudent(String name) {
    	Student s=new Student();
    	s.setName(name);
    	sRepo.save(s);
    	System.out.println("Student Saved:"+s.getName());
    }
    public void enrollStudentInCourse(Integer stdId,Integer courseId ) {
    	Student s=sRepo.findById(stdId).orElse(null);
    	Course c=cRepo.findById(courseId).orElse(null);
    	if(s==null || c==null) {
    		System.out.println("Either student or course deoes not exist");
    	}else {
    		s.getCourses().add(c);
    		sRepo.save(s);
    		System.out.println("student "+s.getName()+" enrolled in "+c.getTitle());
    		
    	}
    	
    	
    }
    public void showAll() {
    	for(Student s:sRepo.findAll()){
    		System.out.println("Student:"+s.getName()+" Courses:"+s.getCourses());
    	}
    }
    public void deleteStudent(Integer stdId) {
    	Student s=sRepo.findById(stdId).orElse(null);
    	if(s==null) {
    		System.out.println("Student not found");
    		return;
    	}
    	s.getCourses().clear();
    	sRepo.delete(s);
    	System.out.println("Student deleted");
    }
    public void deleteCourse(Integer cId) {
    	Course c=cRepo.findById(cId).orElse(null);
    	if(c==null) {
    		System.out.println("Course not found");
    		return;
    	}
    	sRepo.deleteCourseStudent(cId);
    	cRepo.delete(c);
    	System.out.println("Course deleted:");
    }
}
