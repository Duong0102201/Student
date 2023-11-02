package com.developer.SpringMySql.services;

import com.developer.SpringMySql.dto.DepartmentDto;
import com.developer.SpringMySql.dto.DepartmentMapDto;

import com.developer.SpringMySql.models.Department;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getAll();

    DepartmentMapDto search(DepartmentDto departmentDto, Pageable pageable);

    List<DepartmentDto> findByDepartName(String departName);

    boolean delete(Integer departId);



}
