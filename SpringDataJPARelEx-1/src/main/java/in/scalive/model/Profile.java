package in.scalive.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profile {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String bio; 
    public Profile() {
    	
    }
    public Profile(String bio) {
    	this.bio=bio;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
    
}
