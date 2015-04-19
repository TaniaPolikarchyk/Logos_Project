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
import ua.lviv.lgs.model.Teachers;
import ua.lviv.lgs.service.TeachersService;

@Service("teachersService")
public class TeachersServiceImpl implements TeachersService {
	@Autowired
	private TeachersDao dao;

	@Override
	public Iterable<Teachers> viewAllTeachers() {
				return dao.findAll();
	}

	@Override
	@Transactional
	public void addTeacher(Teachers teacher) {
		dao.save(teacher);
		
	}

	@Override
	@Transactional
	public void editTeacher(Integer id, Teachers teacher) {
		 Teachers newTeacher = (Teachers) dao.findOne(id);
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
	public Iterable<Teachers> sortTeachersByFirstName(Sort firstName) {
		return dao.findAll(firstName);
	}

	@Override
	public Iterable<Teachers> sortTeachersByDepartment(Sort department) {
		return dao.findAll(department);
	}

	@Override
	public Iterable<Teachers> sortTeachersByFaculty(Sort faculty) {
		return dao.findAll(faculty);
	}

	@Override
	public Set<Teachers> filterTeacherByFirstName(String firstName) {
		Iterable setofAllTeachers = dao.findAll();
		Set<Teachers> filteredTeachers = new HashSet<Teachers>();
		Iterator itr = setofAllTeachers.iterator();
		while(itr.hasNext()){
			Teachers t = (Teachers) itr.next();
			if(t.getFirstName().equals(firstName)){
				filteredTeachers.add(t);
			}
		}
		return filteredTeachers;
	}

	@Override
	public Set<Teachers> filterTeacherByDepartment(String department) {
		Iterable setofAllTeachers = dao.findAll();
		Set<Teachers> filteredTeachers = new HashSet<Teachers>();
		Iterator itr = setofAllTeachers.iterator();
		while(itr.hasNext()){
			Teachers t = (Teachers) itr.next();
			if(t.getDepartment().equals(department)){
				filteredTeachers.add(t);
			}
		}
		return filteredTeachers;
	}

	@Override
	public Set<Teachers> filterTeacherByFaculty(String faculty) {
		Iterable setofAllTeachers = dao.findAll();
		Set<Teachers> filteredTeachers = new HashSet<Teachers>();
		Iterator itr = setofAllTeachers.iterator();
		while(itr.hasNext()){
			Teachers t = (Teachers) itr.next();
			if(t.getDepartment().getFaculty().equals(faculty)){
				filteredTeachers.add(t);
			}
		}
		return filteredTeachers;
	}

	
}
