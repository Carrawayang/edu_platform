package com.platform.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Description：
 *
 * @author yanwei
 * Date: 2021/4/20 10:07
 **/
@EnableTransactionManagement
@Configuration
@MapperScan("com.platform.eduservice.mapper")
public class EduConfig {

//    /**
////     * 逻辑删除插件，高版本mp不用写
////     */
////    @Bean
////    public ISqlInjector sqlInjector() {
////        return new LogicSqlInjector();
////    }


    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
