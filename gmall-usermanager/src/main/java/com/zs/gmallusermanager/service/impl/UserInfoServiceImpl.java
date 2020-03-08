package com.zs.gmallusermanager.service.impl;

import com.zs.gmallusermanager.bean.UserInfo;
import com.zs.gmallusermanager.mapper.UserInfoMapper;
import com.zs.gmallusermanager.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    // 调用数据访问层 @Autowired 自动注入，前提条件？将UserInfoMapper 放入spring 容器
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public UserInfo getUserInfoByName(String name) {
        return null;
    }

    @Override
    public List<UserInfo> getUserInfoListByName(UserInfo userInfo) {
        // return userInfoMapper.select(userInfo);
        Example example = new Example(UserInfo.class);
        // 第一个参数：实体类的属性，还是数据库中的字段
        example.createCriteria().andEqualTo("name",userInfo.getName());
        // example :设置查询条件！
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public List<UserInfo> getUserInfoListByNickName(UserInfo userInfo) {
        // select * from userInfo where nickName like %?%;
        Example example = new Example(UserInfo.class);
        // 第一个参数：实体类的属性，还是数据库中的字段
        example.createCriteria().andLike("nickName","%"+userInfo.getNickName()+"%");
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(example);

        return userInfoList;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

//    @Override
//    public void updUser(UserInfo userInfo) {
//        // update from userInfo set name= ? where id= ?
//        userInfoMapper.updateByPrimaryKey(userInfo);
//
//    }

//    @Override
//    public void updUser(UserInfo userInfo) {
//        // update from userInfo set name= ? where id= ?
//        userInfoMapper.updateByPrimaryKeySelective(userInfo);
//    }

    @Override
    public void updUser(UserInfo userInfo) {
        // update from userInfo set nickName=? where name= ?
        // 第一个参数：userInfo 修改的内容
        // 第二个参数：example 设置条件
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.updateByExampleSelective(userInfo,example);

    }

    @Override
    public void delUser(UserInfo userInfo) {
        // delete from userInfo where name = ?

//        Example example = new Example(UserInfo.class);
//        example.createCriteria().andEqualTo("name",userInfo.getName());
//
//        userInfoMapper.deleteByExample(example);

        userInfoMapper.delete(userInfo);

    }
}
