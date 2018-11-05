package com.lijwen.employee.controller;

import com.lijwen.employee.domain.Employee;
import com.lijwen.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/5 0005
 * Time:下午 10:45
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employee/employeelist")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployeeList();
    }

    @PostMapping(value = "/employee/addone")
    public Employee addEmployee(@PathVariable("emplid") String emplid,
                                @PathVariable("emplname") String emplname,
                                @PathVariable("notesid") String notesid) {
        Employee e = new Employee();
        e.setEmplid(emplid);
        e.setEmplname(emplname);
        e.setNotesid(notesid);
        return employeeService.addEmployee(e);
    }

}
