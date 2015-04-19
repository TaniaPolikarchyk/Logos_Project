package ua.lviv.lgs.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teachers")
public class Teachers {
	
	@Id
	@GeneratedValue
	@Column(name="idTeacher")
	private int id;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="YearOfBirth")
	private int yearOfBirth;
	
	@Column(name="Course")
	private int course;
	
	@Column(name="URLPicture")
	private String urlPicture;
	
	@ManyToOne()
	@JoinColumn(name="idDepartment")
	private Department department;
	
	@OneToMany(mappedBy="teachers", fetch= FetchType.EAGER)
	private Set<Subjects> subjects;
	
	public Teachers() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subjects> subjects) {
		this.subjects = subjects;
	}

	public String toString() {
		return ("Detailed information about this Teacher: 1. Teacher's ID: " + id + "2. Teacher's First Name: " + 
	firstName + "3. Teacher's Last Name: " + lastName +  "4. Teacher's Year of Birth: " + yearOfBirth + 
	"5.Course:" + course + 	"6.Department, on which teacher works: " + department + 
	"7. Subjects tought by tercher: "+  subjects +" 8. Teacher's photo");
	}
}
