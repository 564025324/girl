package com.lijwen.webAttendance.repository;

import com.lijwen.webAttendance.staff.StaffBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffBean, Integer> {
    // 根据id进行查询
    StaffBean getStaffBeanByStaffId(Integer staffid);
}
