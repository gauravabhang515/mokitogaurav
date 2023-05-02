package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue

    private int empId;

    private String empName;

    private String empAddress;

    private double empSalary;

    private long empContactNumber;

    private String empEmailId;

    private String empPassword;
}
