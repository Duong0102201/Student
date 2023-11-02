package com.developer.SpringMySql.Repo;


import com.developer.SpringMySql.models.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepo extends CrudRepository<Department, Integer> {

    List<Department> findByDepartName(String departName);

    boolean existsByDepartIdEquals(Integer departId);

    List<Department> findOneByDepartId(Integer departId);

}
