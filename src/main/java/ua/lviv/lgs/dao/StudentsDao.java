package ua.lviv.lgs.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import ua.lviv.lgs.model.Students;

public interface StudentsDao extends
		PagingAndSortingRepository<Students, Integer> {

}
