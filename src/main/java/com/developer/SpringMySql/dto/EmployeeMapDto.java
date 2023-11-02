package com.developer.SpringMySql.dto;

import java.util.List;

public class EmployeeMapDto {

    private Integer numberOfItems;
    private List<EmployeeDto> dtoList;

    public EmployeeMapDto() {
    }

    public EmployeeMapDto(Integer numberOfItems, List<EmployeeDto> dtoList) {
        this.numberOfItems = numberOfItems;
        this.dtoList = dtoList;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public List<EmployeeDto> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<EmployeeDto> dtoList) {
        this.dtoList = dtoList;
    }
}
