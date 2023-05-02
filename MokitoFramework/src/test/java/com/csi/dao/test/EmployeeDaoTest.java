package com.csi.dao.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)


public class EmployeeDaoTest {
    @Autowired
    EmployeeDao employeeDaoImpl;

    @MockBean
    EmployeeRepo employeeRepoImpl;

    @Test

    public void saveData() {
        Employee employee = new Employee(1, "gaurac", "nshik", 45000, 45487878, "gau@csi", "ddddd");
        employeeDaoImpl.saveData(employee);

        verify(employeeRepoImpl, times(1)).save(employee);
    }

    @Test

    public void getAllData() {

        when(employeeRepoImpl.findAll()).thenReturn((List<Employee>) Stream.of(new Employee(1, "gaurav", "pune", 55000, 98745487, "gau@xsi", "4444"),
                (new Employee(2, "anku", "nahsik", 45000, 8754621, "anku@xsi", "444")),
                (new Employee(3, "saish", "mumbai", 35000, 9654781, "sai@xsi", "5555")),
                (new Employee(4, "yash", "pcmc", 95000, 98745487, "yash@xsi", "4445554"))).collect(Collectors.toList()));

        assertEquals(4, employeeDaoImpl.getAllData().size());

    }

    @Test

    public void updataData() {


        Employee employee = new Employee(1, "gaurac", "nshik", 45000, 45487878, "gau@csi", "ddddd");
        employeeDaoImpl.updateData(employee);

        verify(employeeRepoImpl, times(1)).save(employee);

    }


    @Test

    public void deleteData() {

        Employee employee = new Employee(1, "gaurac", "nshik", 45000, 45487878, "gau@csi", "ddddd");
        employeeDaoImpl.deleteDataById(employee.getEmpId());

        verify(employeeRepoImpl, times(1)).deleteById(employee.getEmpId());
    }


}
