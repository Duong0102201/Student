package com.developer.SpringMySql.services;

import com.developer.SpringMySql.dto.DepartmentDto;
import com.developer.SpringMySql.dto.EmployeeDto;
import com.developer.SpringMySql.dto.EmployeeMapDto;
import com.developer.SpringMySql.models.SearchInfoToDo;
import org.hibernate.service.spi.ServiceException;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

//    List<EmployeeDto> getAll() ;

    Optional<EmployeeDto> findById(int empId);

    EmployeeDto save(EmployeeDto employeeDto) throws ServiceException;

    List<DepartmentDto> getDepartment();

    void deleteById(int empId);

    EmployeeMapDto search(EmployeeDto employeeDto, Pageable pageable);
}
