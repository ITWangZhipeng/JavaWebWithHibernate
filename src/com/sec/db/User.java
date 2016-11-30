package com.sec.db;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/30.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @Basic
    @Column(name = "工号", unique = true, length = 8)
    private String WorkID;

    @Basic
    @Column(name = "用户名")
    private String userName;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "utid")
    private Set<TongZhiDan> tongZhiDens;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ujid")
    private Set<JiGui> jiGuis;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ucid")
    private Set<ChuanZhen> chuanZhens;

    @Basic
    private String password;
    public User() {
    }

    public User(String workID, String userName, String pwd) {
        WorkID = workID;
        this.userName = userName;
        this.password = pwd;
    }

    public int getSid() {
        return sid;
    }

    public String getWorkID() {
        return WorkID;
    }

    public String getUserName() {
        return userName;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setWorkID(String workID) {
        WorkID = workID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<TongZhiDan> getTongZhiDens() {
        return tongZhiDens;
    }

    public Set<JiGui> getJiGuis() {
        return jiGuis;
    }

    public Set<ChuanZhen> getChuanZhens() {
        return chuanZhens;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTongZhiDens(Set<TongZhiDan> tongZhiDens) {
        this.tongZhiDens = tongZhiDens;
    }

    public void setJiGuis(Set<JiGui> jiGuis) {
        this.jiGuis = jiGuis;
    }

    public void setChuanZhens(Set<ChuanZhen> chuanZhens) {
        this.chuanZhens = chuanZhens;
    }


}
