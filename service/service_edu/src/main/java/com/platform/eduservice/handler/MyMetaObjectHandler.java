package com.platform.eduservice.handler;

/**
 * Description：
 *
 * @author yanwei
 * Date: 2021/4/21 14:26
 **/

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Description：
 *
 * @author yanwei
 * Date: 2021/4/20 16:55
 **/

@Component
public  class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //属性名称，不是字段名称
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", Date.class, metaObject);
    }
}
