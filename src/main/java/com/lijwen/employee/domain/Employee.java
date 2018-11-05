package com.lijwen.employee.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 员工基本信息表
 * <p>
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/5 0005
 * Time:下午 10:08
 */

@Entity
@Table(name = "hrm_employee_base")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 5)
    private String emplid;
    private String emplname;
    private String idno;
    private Long mobile;
    private Long mobile2;
    private String telno;
    private Long deptid;
    private String postid;
    private String status;
    private String notesid;
    private String sex;
    private Date indate;
    private Date outdate;
    private String workstatus;

    @OneToMany(targetEntity = Role.class)
    private List<Role> roles;


    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmplid() {
        return emplid;
    }

    public void setEmplid(String emplid) {
        this.emplid = emplid;
    }

    public String getEmplname() {
        return emplname;
    }

    public void setEmplname(String emplname) {
        this.emplname = emplname;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Long getMobile2() {
        return mobile2;
    }

    public void setMobile2(Long mobile2) {
        this.mobile2 = mobile2;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public Long getDeptid() {
        return deptid;
    }

    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotesid() {
        return notesid;
    }

    public void setNotesid(String notesid) {
        this.notesid = notesid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public String getWorkstatus() {
        return workstatus;
    }

    public void setWorkstatus(String workstatus) {
        this.workstatus = workstatus;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
