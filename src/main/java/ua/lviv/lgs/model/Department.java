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
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue
	@Column(name="idDepartment")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "idFaculty")
	private Faculty faculty;
	
	@OneToMany(mappedBy="department", fetch = FetchType.EAGER)
	private Set<SubjectAndCourse> subjectAndCourse;
	
	@OneToMany(mappedBy="department", fetch= FetchType.EAGER)
	private Set<Students> students;
	
	@OneToMany(mappedBy="department", fetch= FetchType.EAGER)
	private Set<Teachers> teachers;
	
	public Department() {
		
	}
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Set<SubjectAndCourse> getSubjectAndCourse() {
		return subjectAndCourse;
	}

	public void setSubjectAndCourse(Set<SubjectAndCourse> subjectAndCourse) {
		this.subjectAndCourse = subjectAndCourse;
	}

	public Set<Students> getStudents() {
		return students;
	}

	public void setStudents(Set<Students> students) {
		this.students = students;
	}

	public Set<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teachers> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
