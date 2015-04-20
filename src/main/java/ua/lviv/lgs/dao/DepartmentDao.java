package ua.lviv.lgs.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import ua.lviv.lgs.model.Department;

public interface DepartmentDao extends PagingAndSortingRepository<Department,Integer> {

}
