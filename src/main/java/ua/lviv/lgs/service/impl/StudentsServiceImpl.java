package ua.lviv.lgs.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.StudentsDao;
import ua.lviv.lgs.model.Department;
import ua.lviv.lgs.model.Faculty;
import ua.lviv.lgs.model.Marks;
import ua.lviv.lgs.model.Students;
import ua.lviv.lgs.model.Subjects;
import ua.lviv.lgs.service.StudentsService;

@Service("studentsService")
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	private StudentsDao dao;

	@Override
	public Iterable<Students> viewAllStudents() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void addStudent(Students student) {
		 dao.save(student);
		
	}

	@Override
	@Transactional
	public void editStudent(Integer id, Students student) {
		Students newStudent = (Students) dao.findOne(id);
		newStudent.setFirstName(student.getFirstName());
		newStudent.setLastName(student.getLastName());
		newStudent.setYearOfBirth(student.getYearOfBirth());
		newStudent.setCourse(student.getCourse());
		newStudent.setDepartment(student.getDepartment());
		newStudent.setMarks(student.getMarks());
		dao.save(newStudent);
		
	}

	@Override
	@Transactional
	public void deleteStudent(Integer id) {
		dao.delete(id);
	}

	@Override
	@Transactional
	public Iterable<Students> sortStudentsByFirstName(Sort firstName) {
		return dao.findAll(firstName);
	}

	@Override
	@Transactional
	public Iterable<Students> sortStudentsByDepartment(Sort department) {
		return dao.findAll(department);
	}

	@Override
	@Transactional
	public Iterable<Students> sortStudentsByFaculty(Sort faculty) {
		return dao.findAll(faculty);
	}

	@Override
	@Transactional
	public Set<Students> studentsFilteredByfirstName(String firstName) {
		Iterable setOfAllStudents = dao.findAll();
		Set<Students> filteredStudents = new HashSet<Students>();
		Iterator itr = setOfAllStudents.iterator();
		while(itr.hasNext()){
			Students s = (Students) itr.next();
			if(s.getFirstName().equals(firstName)){
				filteredStudents.add(s);
			}
		}
		return filteredStudents;
	}

	@Override
	@Transactional
	public Set<Students> studentsFilteredByDepartment(String department) {
		Iterable setOfAllStudents = dao.findAll();
		Set <Students> filteredStudents = new HashSet<Students>();
		Iterator itr = setOfAllStudents.iterator();
		while(itr.hasNext()){
			Students s = (Students)itr.next();
			if(s.getDepartment().equals(department)){
				filteredStudents.add(s);
			}
		}
		return filteredStudents;
	}

	@Override
	@Transactional
	public Set<Students> studentsFilteredByFaculty(String faculty) {
		Iterable setOfAllStudents = dao.findAll();
		Set<Students> filteredStudents= new HashSet<Students>();
		Iterator itr = setOfAllStudents.iterator();
		while(itr.hasNext()){
			Students s = (Students) itr.next();
			if(s.getDepartment().getFaculty().equals(faculty)){
				filteredStudents.add(s);
			}
		}
		return filteredStudents;
	}

		
	
	

}
