package com.little.service.impl;

import com.little.dao.QQAccountInfoDao;
import com.little.domain.QQAccountInfo;
import com.little.service.QQAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

/*
 *
 * QQ 信息控制功能服务类
 *
 * */
@Service
public class QQAccountInfoImpl implements QQAccountInfoService {
    @Autowired
    private QQAccountInfoDao qqAccountInfoDao ;

    public Integer getCountByAccount(String qqAccountInfo){
        return qqAccountInfoDao.getCountByAccount(qqAccountInfo);
    }

    public boolean insertAccountInfo(String username,String password,QQAccountInfo qqAccountInfo){
        //获取对象成员属性
        //自增 uid
        BigInteger uid =qqAccountInfoDao.getMaxUidAccount().add(BigInteger.ONE);
        //取当前时间
        Date currrentdate = new Date();
        boolean accountreapt = true;//是否是重复的已有账号
        //获取一个随机指定长度的字符串作为 QQ 账号
        String accounttext="";
        while(accountreapt){

            Random random = new Random();
            long account = random.nextLong() % 10000000000L;
            if (account < 0) {
                account += 10000000000L;
            }
            accounttext=String.valueOf(account);

            Integer count=qqAccountInfoDao.getCountByAccount(accounttext);
            if(count==1){
                accountreapt = true;
            }
            else{
                accountreapt = false;
            }
        }
        //设置输出对象成员属性
        qqAccountInfo.setAccount(accounttext);
        qqAccountInfo.setPassword(password);
        qqAccountInfo.setUid(uid);
        qqAccountInfo.setCreatedate(currrentdate);
        return qqAccountInfoDao.insertAccountInfo(qqAccountInfo);
    }

    public boolean selectAccountInfoByAccount(String account,QQAccountInfo qqAccountInfo){
        QQAccountInfo tempqqAccountInfo=qqAccountInfoDao.selectAccountInfoByAccount(account);
        if(tempqqAccountInfo.getAccount().length()==10){
            qqAccountInfo.setUid(tempqqAccountInfo.getUid());
            qqAccountInfo.setAccount(tempqqAccountInfo.getAccount());
            qqAccountInfo.setPassword(tempqqAccountInfo.getPassword());
            qqAccountInfo.setCreatedate(tempqqAccountInfo.getCreatedate());
            return true;
        }else{
            return false;
        }
    }
}
