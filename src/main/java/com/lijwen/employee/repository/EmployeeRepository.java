package com.lijwen.employee.repository;

import com.lijwen.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/5 0005
 * Time:下午 11:16
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
