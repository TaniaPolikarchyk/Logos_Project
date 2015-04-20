package ua.lviv.lgs.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import ua.lviv.lgs.model.Faculty;

public interface FacultyDao extends PagingAndSortingRepository <Faculty,Integer> {

	

}
