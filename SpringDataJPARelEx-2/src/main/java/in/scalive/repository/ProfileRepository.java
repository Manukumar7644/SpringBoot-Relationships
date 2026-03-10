package in.scalive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.scalive.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
