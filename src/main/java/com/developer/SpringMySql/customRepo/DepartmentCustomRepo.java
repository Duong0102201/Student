package com.developer.SpringMySql.customRepo;

import com.developer.SpringMySql.dto.DepartmentDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentCustomRepo {

    List<DepartmentDto> search(DepartmentDto departmentDto, Pageable pageable);

    Integer getNumberOfItemsByRequest(DepartmentDto departmentDto);

    void delete(Integer id);

}
