package in.scalive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.scalive.model.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
