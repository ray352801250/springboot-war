package com.dodoca.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    /**
     * 将配置文件中的druid相关参数注入
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * 配置druid监控
     * 1.配置一个管理后台的servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        //配置druid的后台访问账户密码
        map.put("loginUsername", "admin");
        map.put("loginPassword", "admin");
        map.put("allow", "");//默认允许所有访问
        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }

    /**
     * 2.配置web监控的filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean =new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        //放行的请求
        initParams.put("exclusions","*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(initParams);
        //拦截所有的请求
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }

}
