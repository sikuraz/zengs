package com.zs.gmallusermanager.service;


import com.zs.gmallusermanager.bean.UserInfo;

import java.util.List;

// 业务逻辑层
public interface UserInfoService {

    /**
     * 查询所有用户数据
     * @return
     */
    List<UserInfo> findAll();

    /**
     *
     * @param name
     * @return
     */
    UserInfo getUserInfoByName(String name);

    /**
     *
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserInfoListByName(UserInfo userInfo);
    /**
     *
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserInfoListByNickName(UserInfo userInfo);
    // int ,boolean, void

    /**
     * 添加用户信息
     * @param userInfo
     */
    void addUser(UserInfo userInfo);

    /**
     *
     * @param userInfo
     */
    void updUser(UserInfo userInfo);

    /**
     *
     * @param userInfo
     */
    void delUser(UserInfo userInfo);
}
