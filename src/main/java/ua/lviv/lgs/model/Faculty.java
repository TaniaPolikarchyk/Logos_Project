package ua.lviv.lgs.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {
	
	@Id
	@GeneratedValue
	@Column(name="idFaculty")
	private int id;
	
	@Column (name="Name")
	private String name;
	
	@OneToMany(mappedBy="faculty", fetch= FetchType.EAGER)
	private Set<Department> departments;
	
	public Faculty() {
		
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

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + "]";
	}
	
	
}
