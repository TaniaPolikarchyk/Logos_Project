package ua.lviv.lgs.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import ua.lviv.lgs.model.SubjectAndCourse;

public interface SubjectAndCourseDao extends PagingAndSortingRepository<SubjectAndCourse,Integer>{
	}
