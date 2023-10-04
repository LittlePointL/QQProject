package com.little.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/*
* MyBatis 配置类
* */
public class MyBatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(
            //从 Bean 容器自动注入方法参数
            DataSource dataSource
    ){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.little.domain");
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.little.dao");
        return msc;
    }

}
