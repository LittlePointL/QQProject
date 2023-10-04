package com.little.domain;

import java.math.BigInteger;
import java.util.Date;


/*
 *
 * QQ 账户信息实体
 *
 * */
public class QQAccountInfo {

    BigInteger uid;//uid 唯一标识符
    String Account;//QQ 账号
    String Password;//QQ 密码
    Date Createdate;//账号创建时间


    public BigInteger getUid() {
        return uid;
    }

    public String getAccount() {
        return Account;
    }

    public String getPassword() {
        return Password;
    }

    public Date getCreatedate() {
        return Createdate;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setCreatedate(Date createdate) {
        Createdate = createdate;
    }

    @Override
    public String toString() {
        return "QQAccountInfo{" +
                "uid=" + uid +
                ", Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                ", Createdate=" + Createdate +
                '}';
    }
}
