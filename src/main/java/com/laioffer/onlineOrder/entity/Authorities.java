package com.laioffer.onlineOrder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity表示这个class是SQL中的一个table，必须加，不然Hibernate不会转化
@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {

    //序列化，版本号，这里是一个手动放入的随机数，要保证版本的随机数不同
    private static final long serialVersionUID = 8734140534986494039L;

    //@Id表示这个变量是SQL中的PK
    @Id
    private String email;

    private String authorities;

    //下面的分别表示两个变量各自的getter setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
