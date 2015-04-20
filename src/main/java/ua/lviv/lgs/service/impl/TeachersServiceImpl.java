package ua.lviv.lgs.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.TeachersDao;
import ua.lviv.lgs.model.Department;
import ua.lviv.lgs.model.Teacher;
import ua.lviv.lgs.service.TeachersService;

@Service("teachersService")
public class TeachersServiceImpl implements TeachersService {
	@Autowired
	private TeachersDao dao;

	@Override
	public Iterable<Teacher> viewAllTeachers() {
				return dao.findAll();
	}

	@Override
	@Transactional
	public void addTeacher(Teacher teacher) {
		dao.save(teacher);
		
	}

	@Override
	@Transactional
	public void editTeacher(Integer id, Teacher teacher) {
		 Teacher newTeacher = (Teacher) dao.findOne(id);
		 newTeacher.setFirstName(teacher.getFirstName());
		 newTeacher.setLastName(teacher.getLastName());
		 newTeacher.setYearOfBirth(teacher.getYearOfBirth());
		 newTeacher.setCourse(teacher.getCourse());
		 newTeacher.setDepartment(teacher.getDepartment());
		 dao.save(newTeacher);
	}

	@Override
	@Transactional
	public void deleteTeacher(Integer id) {
		dao.delete(id);
		
	}

	@Override
	public Iterable<Teacher> sortTeachersByFirstName(Sort firstName) {
		return dao.findAll(firstName);
	}

	@Override
	public Iterable<Teacher> sortTeachersByDepartment(Sort department) {
		return dao.findAll(department);
	}

	@Override
	public Iterable<Teacher> sortTeachersByFaculty(Sort faculty) {
		return dao.findAll(faculty);
	}

	@Override
	public Set<Teacher> filterTeacherByFirstName(String firstName) {
		Iterable setofAllTeachers = dao.findAll();
		Set<Teacher> filteredTeachers = new HashSet<Teacher>();
		Iterator itr = setofAllTeachers.iterator();
		while(itr.hasNext()){
			Teacher t = (Teacher) itr.next();
			if(t.getFirstName().equals(firstName)){
				filteredTeachers.add(t);
			}
		}
		return filteredTeachers;
	}

	@Override
	public Set<Teacher> filterTeacherByDepartment(String department) {
		Iterable setofAllTeachers = dao.findAll();
		Set<Teacher> filteredTeachers = new HashSet<Teacher>();
		Iterator itr = setofAllTeachers.iterator();
		while(itr.hasNext()){
			Teacher t = (Teacher) itr.next();
			if(t.getDepartment().equals(department)){
				filteredTeachers.add(t);
			}
		}
		return filteredTeachers;
	}

	@Override
	public Set<Teacher> filterTeacherByFaculty(String faculty) {
		Iterable setofAllTeachers = dao.findAll();
		Set<Teacher> filteredTeachers = new HashSet<Teacher>();
		Iterator itr = setofAllTeachers.iterator();
		while(itr.hasNext()){
			Teacher t = (Teacher) itr.next();
			if(t.getDepartment().getFaculty().equals(faculty)){
				filteredTeachers.add(t);
			}
		}
		return filteredTeachers;
	}

	
}
