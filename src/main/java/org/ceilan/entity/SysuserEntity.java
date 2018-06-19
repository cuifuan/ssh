package org.ceilan.entity;

import javax.persistence.*;

/**
 * Author-Date： cuifuan   2018-06-09 下午 3:45
 * Description：系统用户表
 */
@Entity
@Table(name = "sysuser", schema = "ssh")
public class SysuserEntity {
    private int id;
    private String username;
    private String password;
    private Long logintime;
    private Long loginout;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "logintime", nullable = true)
    public Long getLogintime() {
        return logintime;
    }

    public void setLogintime(Long logintime) {
        this.logintime = logintime;
    }

    @Basic
    @Column(name = "loginout", nullable = true)
    public Long getLoginout() {
        return loginout;
    }

    public void setLoginout(Long loginout) {
        this.loginout = loginout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysuserEntity that = (SysuserEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (logintime != null ? !logintime.equals(that.logintime) : that.logintime != null) return false;
        if (loginout != null ? !loginout.equals(that.loginout) : that.loginout != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (logintime != null ? logintime.hashCode() : 0);
        result = 31 * result + (loginout != null ? loginout.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SysuserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", logintime=" + logintime +
                ", loginout=" + loginout +
                '}';
    }
}
