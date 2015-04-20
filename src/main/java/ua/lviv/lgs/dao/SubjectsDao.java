package ua.lviv.lgs.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import ua.lviv.lgs.model.Students;
import ua.lviv.lgs.model.Subjects;

public interface SubjectsDao extends PagingAndSortingRepository<Subjects, Integer> {

	}
