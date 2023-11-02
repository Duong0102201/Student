package com.developer.SpringMySql.Repo;

import com.developer.SpringMySql.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{


    boolean existsByDepartIdEquals(Integer departId);

    List<Employee>findOneByDepartId(Integer departId);

    void deleteByDepartId(Integer departId);







}
