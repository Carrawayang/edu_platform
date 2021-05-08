package com.platform.eduservice.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description：
 *
 * @author yanwei
 * Date: 2021/4/21 14:50
 **/
@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor   //生成无参数构造
public class MyException extends RuntimeException {
    private Integer code;//状态码
    private String msg;//异常信息
}

