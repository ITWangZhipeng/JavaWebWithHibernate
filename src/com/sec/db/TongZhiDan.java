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
    @Column(name = "通知单内容")
    private String content;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "sid", referencedColumnName = "sid")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
