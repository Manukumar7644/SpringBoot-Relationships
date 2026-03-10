package in.scalive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import in.scalive.model.Student;
import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    @Modifying
    @Transactional
	@Query(value="DELETE from student_course where course_id=?1",nativeQuery = true)
	public void deleteCourseStudent(Integer courseId);
}

