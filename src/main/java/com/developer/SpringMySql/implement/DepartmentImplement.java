package com.developer.SpringMySql.implement;

import com.developer.SpringMySql.Repo.DepartmentRepo;
import com.developer.SpringMySql.Repo.EmployeeRepo;
import com.developer.SpringMySql.customRepo.DepartmentCustomRepo;
import com.developer.SpringMySql.dto.DepartmentDto;
import com.developer.SpringMySql.dto.DepartmentMapDto;
import com.developer.SpringMySql.models.Department;
import com.developer.SpringMySql.models.Employee;
import com.developer.SpringMySql.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentImplement implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentCustomRepo departmentCustomRepo;

    @Override
    public List<DepartmentDto> getAll() {
        List<Department> result = (List<Department>) departmentRepo.findAll();

        return result.stream().map(this::converDepartmentEntityToDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentMapDto search(DepartmentDto departmentDto, Pageable pageable) {
        DepartmentMapDto departmentMapDto = new DepartmentMapDto();
        departmentMapDto.setNumberOfItems(departmentCustomRepo.getNumberOfItemsByRequest(departmentDto));
        List<DepartmentDto> entities = departmentCustomRepo.search(departmentDto, pageable);
        departmentMapDto.setList(entities);
        return departmentMapDto;
    }

    @Override
    public List<DepartmentDto> findByDepartName(String departName) {

        List<Department> result = (List<Department>) departmentRepo.findByDepartName(departName);
        return result.stream().map(this::converDepartmentEntityToDto).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer departId) {

            try {
               List<Employee> emp = employeeRepo.findOneByDepartId(departId);
                if (emp == null || emp.isEmpty()){
                    departmentRepo.deleteById(departId);
                }else{
                    return false;
                }


//                if (departmentRepo.existsByDepartIdEquals(departId) || employeeRepo.existsByDepartIdEquals(departId)){
//
//                }

            }catch (Exception ex){
            }
       return true;
    }

    private DepartmentDto converDepartmentEntityToDto(Department department){
        DepartmentDto dto = new DepartmentDto();
        dto.setDepartId(department.getDepartId());
        dto.setDepartName(department.getDepartName());
        dto.setDescription(department.getDescription());
        return dto;
    }
}
