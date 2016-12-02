package com.sec.db;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/30.
 */
@Entity
public class TongZhiDan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;

    @Basic
    @Column(name = "部门")
    private String department;

    @Basic
    @Column(name = "内容")
    private String content;



    public TongZhiDan() {
    }

    public TongZhiDan(String name, String content) {
        this.department = name;
        this.content = content;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setDepartment(String name) {
        this.department = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTid() {
        return tid;
    }

    public String getDepartment() {
        return department;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "com.sec.db.TongZhiDan{" +
                "tid=" + tid +
                ", 部门='" + department + '\'' +
                ", 内容='" + content + '\'' +
                '}';
    }
}
