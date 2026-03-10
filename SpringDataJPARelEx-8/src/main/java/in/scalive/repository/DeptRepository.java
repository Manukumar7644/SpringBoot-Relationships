package in.scalive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.scalive.model.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer>{

}
