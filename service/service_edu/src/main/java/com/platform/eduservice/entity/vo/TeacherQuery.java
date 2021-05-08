package com.platform.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description：
 *
 * @author yanwei
 * Date: 2021/4/21 16:02
 **/
// vo：https://www.huaweicloud.com/articles/9086e12d8f2ac4bb440df1f83111694c.html
@Data
public class TeacherQuery {

    @ApiModelProperty(value = "教师名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2020-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2020-12-01 10:10:10")
    private String end;
}
