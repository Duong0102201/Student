package com.developer.SpringMySql.implement;

import com.developer.SpringMySql.Repo.DepartmentRepo;
import com.developer.SpringMySql.Repo.EmployeeRepo;
import com.developer.SpringMySql.customRepo.EmployeeCustomRepo;
import com.developer.SpringMySql.dto.DepartmentDto;
import com.developer.SpringMySql.dto.EmployeeMapDto;
import com.developer.SpringMySql.models.Department;
import com.developer.SpringMySql.models.Employee;
import com.developer.SpringMySql.dto.EmployeeDto;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.developer.SpringMySql.services.EmployeeService;

import org.springframework.data.domain.Pageable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class EmployeeImplement implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private EmployeeCustomRepo employeeCustomRepo;

//    @Override
//    public List<EmployeeDto> getAll() {
//        List<Employee> result = (List<Employee>) employeeRepo.findAll();
//        return result.stream().map(this::converHrEmployeeEntityToDto).collect(Collectors.toList());
//
//    }

    @Override
    public Optional<EmployeeDto> findById(int empId) {
        Optional<Employee> result = employeeRepo.findById(empId);
        return result.map(this::converHrEmployeeEntityToDto);
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        employeeRepo.save(employee);
        return null;
    }

    @Override
    public List<DepartmentDto> getDepartment() {
        List<Department> result = (List<Department>) departmentRepo.findAll();
        return result.stream().map(this::converDepartmentToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(int empId) {

    try {
        employeeRepo.deleteById(empId);
    }catch (Exception ex){
        throw ex;
    }

    }

    @Override
    public EmployeeMapDto search(EmployeeDto employeeDto, Pageable pageable) {
        EmployeeMapDto employeeMapDto = new EmployeeMapDto();
        employeeMapDto.setNumberOfItems(employeeCustomRepo.getNumberOfItemsByRequest(employeeDto));
        List<EmployeeDto> entities = employeeCustomRepo.search(employeeDto, pageable);
        employeeMapDto.setDtoList(entities);
        return employeeMapDto;
    }


    private EmployeeDto converHrEmployeeEntityToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmpId(employee.getEmpId());
        employeeDto.setEmpName(employee.getEmpName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setSex(employee.getSex());
        employeeDto.setBirthday(employee.getBirthday());
        employeeDto.setDepartId(employee.getDepartId());
        employeeDto.setDepartmentName(employee.getDepartment().getDepartName());
        return employeeDto;
    }


    private DepartmentDto converDepartmentToDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartId(department.getDepartId());
        departmentDto.setDepartName(department.getDepartName());
        departmentDto.setDescription(department.getDescription());
        return departmentDto;
    }

}
