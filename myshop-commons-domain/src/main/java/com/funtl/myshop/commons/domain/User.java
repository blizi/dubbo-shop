package com.funtl.myshop.commons.domain;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = -109633054752404691L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login_name")
    private String loginName;

    private String password;

    @Column(name = "re_date")
    private String reDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", reDate='" + reDate + '\'' +
                ", showName='" + showName + '\'' +
                '}';
    }

    @Column(name = "show_name")
    private String showName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return login_name
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return re_date
     */
    public String getReDate() {
        return reDate;
    }

    /**
     * @param reDate
     */
    public void setReDate(String reDate) {
        this.reDate = reDate;
    }

    /**
     * @return show_name
     */
    public String getShowName() {
        return showName;
    }

    /**
     * @param showName
     */
    public void setShowName(String showName) {
        this.showName = showName;
    }
}