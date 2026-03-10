package in.scalive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.scalive.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
