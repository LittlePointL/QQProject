package com.little.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
* SpringMVC 功能并扫描指定的包
* */
@Configuration
@ComponentScan("com.little.controller")
@EnableWebMvc
@EnableTransactionManagement
public class SpringMVCConfig {

}
