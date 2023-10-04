package com.little.controller;

import com.little.config.JsonUtils;
import com.little.domain.QQAccountInfo;
import com.little.service.QQAccountInfoService;
import com.little.service.impl.QQAccountInfoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

/*
 *
 * 管理 QQ 账号控制器
 *
 * */
@RestController
public class QQAccountInfoController {

    @Autowired
    private QQAccountInfoService qqAccountInfoService;

    /*
     * 测试用的首页
     * */
    @GetMapping("/")
    public String getIndex(){
        Integer countaccount = 2;
        countaccount = qqAccountInfoService.getCountByAccount("1303468364");
        return "index";
    }


    /**
     * 添加新的 QQ 账号
     *
     * @param username : 用户名
     * @param  password : 密码
     * @return   插入成功后的 QQ 账号属性 , error : 添加失败
     *
     * */
    @PutMapping("/insertQQAccount")
    public String insertQQAccount(String username,String password)  {
        QQAccountInfo qqAccountInfo = new QQAccountInfo();
        if(qqAccountInfoService.insertAccountInfo(username,password,qqAccountInfo)){
            String qqAccountInfojsontext=JsonUtils.toJson(qqAccountInfo);
            return qqAccountInfojsontext;
        }
        else {
            return "error";
        }
    }

    /**
     * 通过 QQ 账号获取 QQ 完整信息
     *
     * @param account : QQ 账号
     * @return qqAccountInfojsontext : 查找成功后 QQ 账号属性 , error : 查找
     *
     * */
    @GetMapping("/selectQQAccount")
    public String selectQQAccount(String account){
        QQAccountInfo qqAccountInfo = new QQAccountInfo();
        boolean ret=qqAccountInfoService.selectAccountInfoByAccount(account,qqAccountInfo);
        if(ret){
            String qqAccountInfojsontext=JsonUtils.toJson(qqAccountInfo);
            return qqAccountInfojsontext;
        }
        else {
            return "error";
        }


    }
}
