package com.little.dao;

import com.little.domain.QQAccountInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/*
 *
 * QQAccountInfo 数据层操作接口
 *
 * */
@Repository
public interface QQAccountInfoDao {

    /**
     * 获取指定账号的数量
     * */
    @Select("SELECT COUNT(*) FROM qqaccountinfo WHERE Account = #{account};")
    public Integer getCountByAccount(String account);

    /**
     * 获取最大的 uid
     * */
    @Select("SELECT MAX(uid) FROM qqaccountinfo;")
    public BigInteger getMaxUidAccount();

    /**
     * 插入一条新的账户记录
     */
    @Insert("INSERT qqaccountinfo (uid,account,password,createdate) " +
            "VALUES(#{uid},#{Account},#{Password},#{Createdate});")
    public boolean insertAccountInfo(QQAccountInfo accountInfo);

    /**
     * 通过 QQ 账号获取账号信息
     * */
    @Select("SELECT uid,account,password,createdate FROM qqaccountinfo "+
            "WHERE account=#{account};")
    public QQAccountInfo selectAccountInfoByAccount(String account);
}
