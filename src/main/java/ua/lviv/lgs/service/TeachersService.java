package ua.lviv.lgs.service;

import java.util.Set;





import org.springframework.data.domain.Sort;
import ua.lviv.lgs.model.Teachers;

public interface TeachersService {
	
	public Iterable<Teachers> viewAllTeachers();
	public void addTeacher(Teachers teacher);
	public void editTeacher(Integer id, Teachers teacher);
	public Iterable<Teachers> sortTeachersByFirstName(Sort firstName);
	public Iterable<Teachers> sortTeachersByDepartment(Sort department);
	public Iterable<Teachers> sortTeachersByFaculty(Sort faculty);
	public Set<Teachers> filterTeacherByFirstName(String firstName);
	public Set<Teachers> filterTeacherByDepartment(String department);
	public Set<Teachers> filterTeacherByFaculty(String faculty);
	public void deleteTeacher(Integer id);
	}
