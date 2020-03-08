package com.zs.gmallusermanager.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserInfo {
    @Id // 表示主键
    @Column // 列名
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 获取主键自增！ IDENTITY 表示mysql ，oracle:AUTO
    private String id;
    @Column
    private String loginName;
    @Column
    private String nickName;
    @Column
    private String passwd;
    @Column
    private String name;
    @Column
    private String phoneNum;
    @Column
    private String email;
    @Column
    private String headImg;
    @Column
    private String userLevel;
}
