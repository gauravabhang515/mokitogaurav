package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/savedata")

    public ResponseEntity<?> saveData(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Employee> getDataById(@PathVariable int empId) {


        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId).orElseThrow(() -> new RecordNotFoundException("id does not exist")));
    }

    @GetMapping("/getalldata")

    public ResponseEntity<List<?>> getAllData() {
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId, @RequestBody Employee employee) {
        Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(() -> new RecordNotFoundException("Id does not exist"));

        employee1.setEmpName(employee.getEmpName());
        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));
    }


    @DeleteMapping("/deletedatabyid/{empId}")

    public ResponseEntity<String> deleteById(@PathVariable int empId) {
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Deletedddddddddddd");
    }
    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId ,@PathVariable String empPassword){
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }

    @GetMapping("/filterbyname/{empName}")

    public ResponseEntity<List<Employee>> filterByName(@PathVariable String empName){
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(emp->emp.getEmpName().equals(empName)).collect(Collectors.toList()));
    }
    @GetMapping("/filterdatabyaddress/{empAddress}")

    public ResponseEntity<List<Employee>> filterByAddress(@PathVariable String empAddress){
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(emp->emp.getEmpAddress().equals(empAddress)).collect(Collectors.toList()));
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList()));
    }

    @GetMapping("/sayhello")
    public ResponseEntity<String> sayhello(  ) {


        return ResponseEntity.ok("hello,......................");
    }
}
