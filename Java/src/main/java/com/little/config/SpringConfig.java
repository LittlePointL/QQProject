package com.little.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
/*
* 导入其他配置类和配置文件
* */
@Configuration
//扫描指定的包
@ComponentScan({"com.little.service"})
//导入资源配置文件
@PropertySource("classpath:jdbc.properties")
//导入其他配置类
@Import({JdbcConfig.class, MyBatisConfig.class})
public class SpringConfig {

}
