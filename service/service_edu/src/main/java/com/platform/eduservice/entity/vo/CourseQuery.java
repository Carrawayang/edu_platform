package com.platform.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description：
 *
 * @author yanwei
 * Date: 2021/5/6 15:15
 **/
@Data
public class CourseQuery {
        @ApiModelProperty(value = "课程名称,模糊查询")
        private String name;

        @ApiModelProperty(value = "状态 Normal：已发布 Draft：未发布")
        private String status;

}
