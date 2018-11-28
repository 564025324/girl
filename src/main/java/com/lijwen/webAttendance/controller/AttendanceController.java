package com.lijwen.webAttendance.controller;

import com.lijwen.webAttendance.repository.StaffRepository;
import com.lijwen.webAttendance.staff.StaffBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private StaffRepository staffRepository;

    @RequestMapping("/{staffid}/getstaffbyid")
    public StaffBean getStaffByStaffid(@PathVariable("staffid") Integer staffid) {
        StaffBean staff = staffRepository.getStaffBeanByStaffId(staffid);
        return staff;
    }
}
