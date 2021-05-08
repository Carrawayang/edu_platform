package com.platform.eduservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.platform.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author yanwei
 * @since 2021-04-25
 */
public interface EduVideoService extends IService<EduVideo> {
    void removeVideoByCourseId(String courseId);

}
