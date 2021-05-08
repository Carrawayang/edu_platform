package com.platform.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.eduservice.entity.EduTeacher;
import com.platform.eduservice.entity.frontvo.CourseFrontVo;
import com.platform.eduservice.entity.frontvo.CourseWebVo;
import com.platform.eduservice.entity.vo.CourseInfoVo;
import com.platform.eduservice.entity.vo.CourseQuery;
import com.platform.eduservice.entity.vo.TeacherQuery;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author yanwei
 * @since 2021-04-22
 */
@Service
public interface EduCourseService extends IService<EduCourse> {
    //添加课程基本信息的方法
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    //根据课程id查询课程基本信息
    CourseInfoVo getCourseInfo(String courseId);

    //修改课程信息
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    //根据课程id查询课程确认信息
//    CoursePublishVo publishCourseInfo(String id);

    //删除课程
    void removeCourse(String courseId);

    //1 条件查询带分页查询课程前台
    Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);

    //根据课程id，编写sql语句查询课程信息
    CourseWebVo getBaseCourseInfo(String courseId);

//    void pageQuery(Page<EduCourse> pageParam, CourseQuery courseQuery);

}
