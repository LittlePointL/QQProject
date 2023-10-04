package com.little.service;

import com.little.domain.QQAccountInfo;

import java.math.BigInteger;


/*
 *
 * QQ 信息控制功能服务接口
 *
 * */
public interface QQAccountInfoService{
    /**
     * 获取指定账号是否存在
     *
     * @param account 用户账号
     * @return 0 : 不存在 , 1 : 存在
     *
     * */
    public Integer getCountByAccount(String account);

    /**
     * 插入新的 QQ 信息记录到 qqaccountinfo
     *
     * @param username : 用户名
     * @param  password : 密码
     * @param  qqAccountInfo : 输出 QQ 账户信息
     * @return true : 插入成功 , false : 插入失败
     *
     * */
    public boolean insertAccountInfo(String username,String password,QQAccountInfo qqAccountInfo);

    /**
     * 通过 QQ 账号获取 QQ 完整信息
     *
     * @param account : QQ 账号
     * @param  qqAccountInfo : 输出 QQ 账户信息
     * @return true : 查找成功 , false : 查找失败
     *
     * */
    public boolean selectAccountInfoByAccount(String account,QQAccountInfo qqAccountInfo);
}
