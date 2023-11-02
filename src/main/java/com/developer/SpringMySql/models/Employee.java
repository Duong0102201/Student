package com.developer.SpringMySql.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "Age")
    private Integer age;
    @Column(name = "Sex")
    private int sex;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "depart_id")
    private int departId;


//     private String departName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depart_id", insertable = false, updatable = false)
    private Department  department;



    public Employee() {
    }

    public Employee(Integer empId, String empName, Integer age, Integer sex, Date birthday, int departId, String departName, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.departId = departId;
//        this.departName = departName;
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

//    public String getDepartName() {
//        return departName;
//    }
//
//    public void setDepartName(String departName) {
//        this.departName = departName;
//    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee that = (Employee) o;
        return sex == that.sex &&
                departId == that.departId;
    }

    @Override
    public int hashCode() {
        return Objects.hash( departId);
    }
}
