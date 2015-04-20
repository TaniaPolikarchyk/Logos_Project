package ua.lviv.lgs.service;

import java.util.Set;





import org.springframework.data.domain.Sort;
import ua.lviv.lgs.model.Teacher;

public interface TeachersService {
	
	public Iterable<Teacher> viewAllTeachers();
	public void addTeacher(Teacher teacher);
	public void editTeacher(Integer id, Teacher teacher);
	public Iterable<Teacher> sortTeachersByFirstName(Sort firstName);
	public Iterable<Teacher> sortTeachersByDepartment(Sort department);
	public Iterable<Teacher> sortTeachersByFaculty(Sort faculty);
	public Set<Teacher> filterTeacherByFirstName(String firstName);
	public Set<Teacher> filterTeacherByDepartment(String department);
	public Set<Teacher> filterTeacherByFaculty(String faculty);
	public void deleteTeacher(Integer id);
	}
