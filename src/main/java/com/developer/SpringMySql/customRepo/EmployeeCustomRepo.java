package com.developer.SpringMySql.customRepo;

import com.developer.SpringMySql.dto.EmployeeDto;
import com.developer.SpringMySql.models.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeCustomRepo {

        List<Employee> getById(Integer empId);

        List<Employee> getByEmpId(Integer empId);

        Integer getNumberOfItemsByRequest(EmployeeDto employeeDto);

        List<EmployeeDto> search(EmployeeDto employeeDto, Pageable pageable);
}
