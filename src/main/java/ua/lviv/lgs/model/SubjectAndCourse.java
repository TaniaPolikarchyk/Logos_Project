package ua.lviv.lgs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subjectandcourse")
public class SubjectAndCourse {
	
	@Id
	@GeneratedValue
	@Column(name="idSubjectAndCourse")
	private int id;
	
	@Column(name="Course")
	private int course;
	
	@ManyToOne
	@JoinColumn(name="idDepartment")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="idSubjects")
	private Subjects subjects;
	
	public SubjectAndCourse() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "SubjectAndCourse [id=" + id + ", course=" + course
				+ ", department=" + department + ", subjects=" + subjects + "]";
	}
	
	
	
}
