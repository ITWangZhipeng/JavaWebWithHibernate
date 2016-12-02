package com.sec.db;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/30.
 */
@Entity
public class ChuanZhen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    @Basic
    @Column(name = "department")
    private String department="传真";


    public ChuanZhen() {
    }

    public int getCid() {
        return cid;
    }

    public String getDepartment() {
        return department;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "com.sec.db.ChuanZhen{" +
                "cid=" + cid +
                ", 部门='" + department + '\'' +
                '}';
    }
}
