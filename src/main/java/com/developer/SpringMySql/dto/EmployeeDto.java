package com.developer.SpringMySql.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EmployeeDto {

    private int empId;
    private String empName;
    private int age;
    private int sex;
    private Date birthday;
    private int departId;
    private String departmentName;
    private List<EmployeeDto> employeeDtoList;



    public EmployeeDto() {
    }

    public EmployeeDto(Integer empId, String empName, Integer age, Integer sex, Date birthday,Integer departId ,String departmentName) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.departId = departId;
        this.departmentName = departmentName;
    }

    public EmployeeDto(int empId, String empName, int age, Integer sex, Date birthday, int departId, String departmentName, List<EmployeeDto> employeeDtoList) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.departId = departId;
        this.departmentName = departmentName;
        this.employeeDtoList = employeeDtoList;
    }



    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<EmployeeDto> getEmployeeDtoList() {
        return employeeDtoList;
    }

    public void setEmployeeDtoList(List<EmployeeDto> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }
}
