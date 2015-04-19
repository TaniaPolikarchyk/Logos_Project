package ua.lviv.lgs.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="marks")
public class Marks {
	
	@Id
	@GeneratedValue
	@Column(name="idMarks")
	private int id;
	
	@Column(name="Name")
	private int value;
	
	@ManyToMany(mappedBy="marks", fetch= FetchType.EAGER)
	private Set<Students> students;
	
	@ManyToOne
	@JoinColumn(name="idSubjects")
	private Subjects subject;
	
	public Marks() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Set<Students> getStudents() {
		return students;
	}

	public void setStudents(Set<Students> students) {
		this.students = students;
	}

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Marks [id=" + id + ", value=" + value + ", students="
				+ students + ", subject=" + subject + "]";
	}

}
	
	
