package com.zs.gmallusermanager.controller;


import com.zs.gmallusermanager.bean.UserInfo;
import com.zs.gmallusermanager.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    // 方法返回值，方法的传入参数！
//    @RequestMapping("findAll")
//    public String findAll(){
//          userInfoService.findAll();
//        // list.html
//        return "list";
//    }
    @RequestMapping("findAll")
    @ResponseBody // @ResponseBody 返回json 字符串， 还可以将数据直接显示到页面！
    public List<UserInfo> findAll(){
        // list.html
        return userInfoService.findAll();
    }
    /*
        <form action = "findUserByName" method = "get">
        <input type = "text" name="name"/>
        <input type="submit" value="查询"/>
     */
    // localhost:8080/findUserByName?name=Admin
    // springmvc 对象传值
    @RequestMapping("findUserByName")
    @ResponseBody // @ResponseBody 返回json 字符串， 还可以将数据直接显示到页面！
    public List<UserInfo> findUserByName(UserInfo userInfo, HttpServletRequest request){
        //  String name = request.getParameter("name");
        //  UserInfo userInfo1 = new UserInfo();
        //  userInfo1.setName(name);
        // list.html
        // select * from userInfo where name = ?
        return userInfoService.getUserInfoListByName(userInfo);
    }

    // http://localhost:8080/findUserByNickName?nickName=A
    @RequestMapping("findUserByNickName")
    @ResponseBody // @ResponseBody 返回json 字符串， 还可以将数据直接显示到页面！
    public List<UserInfo> findUserByName(UserInfo userInfo){

        return userInfoService.getUserInfoListByNickName(userInfo);
    }

    // http://localhost:8080/findUserByNickName?nickName=A
    @RequestMapping("addUser")
    @ResponseBody // @ResponseBody 返回json 字符串， 还可以将数据直接显示到页面！
    public void addUser(UserInfo userInfo){
        userInfo.setName("0311 大神班");
        userInfo.setLoginName("漂亮");
        userInfo.setPasswd("完美");
        userInfoService.addUser(userInfo);

        // 获取新增的主键Id
        System.out.println(userInfo.getId());
    }
    // http://localhost:8080/updUser?id=5&name=888
    // http://localhost:8080/updUser?name=888&nickName=666
    @RequestMapping("updUser")
    @ResponseBody // @ResponseBody 返回json 字符串， 还可以将数据直接显示到页面！
    public void updUser(UserInfo userInfo){
        // update from userInfo set name= ? where id= ?
        userInfoService.updUser(userInfo);
    }

    // http://localhost:8080/delUser?name=888
    @RequestMapping("delUser")
    @ResponseBody // @ResponseBody 返回json 字符串， 还可以将数据直接显示到页面！
    public void delUser(UserInfo userInfo){

        userInfoService.delUser(userInfo);
    }
}
