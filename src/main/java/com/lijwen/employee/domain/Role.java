package com.lijwen.employee.domain;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/5 0005
 * Time:下午 10:21
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色表
 */
@Entity
@Table(name = "hrm_employee_role")
public class Role {
    @Id
    private Integer roleid;
    private String rolename;
    private String status;

    public Role() {
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
