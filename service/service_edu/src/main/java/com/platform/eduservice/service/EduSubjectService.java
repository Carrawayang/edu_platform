package com.platform.eduservice.service;

import com.platform.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author yanwei
 * @since 2021-04-25
 */
public interface EduSubjectService extends IService<EduSubject> {

    //添加课程分类
    void saveSubject(MultipartFile file, EduSubjectService subjectService);

    //课程分类列表（树形）
    List<OneSubject> getAllOneTwoSubject();
}
