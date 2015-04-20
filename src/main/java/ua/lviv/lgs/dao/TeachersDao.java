package ua.lviv.lgs.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import ua.lviv.lgs.model.Students;
import ua.lviv.lgs.model.Teacher;

public  interface TeachersDao extends PagingAndSortingRepository<Teacher, Integer> {

	}
