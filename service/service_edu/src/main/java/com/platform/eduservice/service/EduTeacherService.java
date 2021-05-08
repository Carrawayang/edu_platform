package com.platform.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.eduservice.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author yanwei
 * @since 2021-04-20
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);
}
