package ua.lviv.lgs.model;

import java.util.List;
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
@Table(name="subjects")
public class Subjects {
	
	@Id
	@GeneratedValue
	@Column(name="idSubjects")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="idTeacher")
	private Teachers teachers;
	
	@OneToMany(mappedBy= "subjects", fetch= FetchType.EAGER)
	private List<Marks> marks;
	
	@OneToMany(mappedBy="subjects", fetch= FetchType.EAGER)
	private Set<SubjectAndCourse> subjectAndCourse;
	
	
	public Subjects() {
		
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

	public Teachers getTeachers() {
		return teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
		}
	
	public Set<SubjectAndCourse> getSubjectAndCourse() {
		return subjectAndCourse;
	}

	public void setSubjectAndCourse(Set<SubjectAndCourse> subjectAndCourse) {
		this.subjectAndCourse = subjectAndCourse;
	}

	public List<Marks> getMarks() {
		return marks;
	}

	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Subjects [name=" + name + ", teachers=" + teachers + ", marks="
				+ marks + ", subjectAndCourse=" + subjectAndCourse + "]";
	}
	
	
	
	
	
}
