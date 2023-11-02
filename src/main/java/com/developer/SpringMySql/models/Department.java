package com.developer.SpringMySql.models;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "depart_id")
    private int departId ;

    @Column(name = "depart_name")
    private String departName;

    @Column(name = "Description")
    private String description;

    public Department() {
    }

    public Department(int departId, String departName, String description) {
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
}
