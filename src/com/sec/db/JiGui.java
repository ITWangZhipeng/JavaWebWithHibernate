package com.sec.db;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/30.
 */
@Entity
public class JiGui {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jid;
    @Basic
    @Column(name = "机规")
    private String department="机规";
    @Basic
    @Column(name = "机规内容")
    private String content;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "sid", referencedColumnName = "sid")
    private User user;

    public JiGui() {
    }

    public JiGui(String department, String content) {
        this.department = department;
        this.content = content;
    }

    public int getJid() {
        return jid;
    }

    public String getDepartment() {
        return department;
    }

    public String getContent() {
        return content;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
