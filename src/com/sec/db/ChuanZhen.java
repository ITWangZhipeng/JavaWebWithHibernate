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
    @Column(name = "传真")
    private String department="传真";

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "sid", referencedColumnName = "sid")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
