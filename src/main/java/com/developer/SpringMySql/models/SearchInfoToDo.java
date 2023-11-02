package com.developer.SpringMySql.models;

import com.developer.SpringMySql.dto.DepartmentDto;

import java.io.Serializable;
import java.util.List;

public class SearchInfoToDo implements Serializable {

    private List<DepartmentDto>departmentDtoList;

    public SearchInfoToDo() {
    }

    public SearchInfoToDo(List<DepartmentDto> departmentDtoList) {
        this.departmentDtoList = departmentDtoList;
    }

    public List<DepartmentDto> getDepartmentDtoList() {
        return departmentDtoList;
    }

    public void setDepartmentDtoList(List<DepartmentDto> departmentDtoList) {
        this.departmentDtoList = departmentDtoList;
    }
}
