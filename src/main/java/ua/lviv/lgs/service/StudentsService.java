package ua.lviv.lgs.service;

import java.util.Set;




import org.springframework.data.domain.Sort;

import ua.lviv.lgs.model.Department;
import ua.lviv.lgs.model.Faculty;
import ua.lviv.lgs.model.Students;

public interface StudentsService {
	public Iterable<Students> viewAllStudents();
	public void addStudent(Students student);
	public void editStudent(Integer id, Students student);
	public Iterable<Students> sortStudentsByFirstName(Sort firstName);
	public Iterable<Students> sortStudentsByDepartment(Sort department);
	public Iterable<Students> sortStudentsByFaculty(Sort faculty);
	public Set <Students> studentsFilteredByfirstName(String firstName);
	public Set <Students> studentsFilteredByDepartment(String department);
	public Set <Students> studentsFilteredByFaculty(String faculty);
	public void deleteStudent(Integer id);
	
}
