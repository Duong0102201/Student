package com.developer.SpringMySql.dto;

import java.util.List;

public class DepartmentDto {

    private int departId;
    private String departName;
    private String description;
    private List<DepartmentDto> listDepartMent;

    public DepartmentDto() {
    }

    public DepartmentDto(int departId, String departName, String description, List<DepartmentDto> listDepartMent) {
        this.departId = departId;
        this.departName = departName;
        this.description = description;
        this.listDepartMent = listDepartMent;
    }

    public DepartmentDto(Integer departId, String departName, String description) {
        this.departId = departId;
        this.departName = departName;
        this.description = description;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DepartmentDto> getListDepartMent() {
        return listDepartMent;
    }

    public void setListDepartMent(List<DepartmentDto> listDepartMent) {
        this.listDepartMent = listDepartMent;
    }
}
