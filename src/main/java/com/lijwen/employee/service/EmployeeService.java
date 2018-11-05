package com.lijwen.employee.service;

import com.lijwen.employee.domain.Employee;
import com.lijwen.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/6 0006
 * Time:上午 12:23
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    /**
     * 获取所有员工信息
     *
     * @return
     */
    public List<Employee> getAllEmployeeList() {
        return employeeRepository.findAll();
    }

    /**
     * 将传入的一个对象插入到数据库中
     *
     * @param e
     * @return
     */
    public Employee addEmployee(Employee e) {
        return employeeRepository.save(e);
    }

}
