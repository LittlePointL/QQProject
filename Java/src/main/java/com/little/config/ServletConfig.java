package com.little.config;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import java.util.List;

/*
* Web Servlet 服务功能配置类
* */
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[]getRootConfigClasses(){
        return new Class[]{SpringConfig.class};
    }

    //指定 MVC 配置类
    protected  Class<?>[]getServletConfigClasses(){
        return new Class[]{SpringMVCConfig.class};
    }

    //拦截所有的请求
    protected String[]getServletMappings(){
        return new String[]{"/"};
    }

}
