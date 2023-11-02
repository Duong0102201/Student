package com.developer.SpringMySql.dto;

import java.util.List;

public class DepartmentMapDto {

    private Integer numberOfItems;
    private List<DepartmentDto> list;

    public DepartmentMapDto() {
    }

    public DepartmentMapDto(Integer numberOfItems, List<DepartmentDto> list) {
        this.numberOfItems = numberOfItems;
        this.list = list;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public List<DepartmentDto> getList() {
        return list;
    }

    public void setList(List<DepartmentDto> list) {
        this.list = list;
    }
}
