package com.platform.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.commonutils.R;
import com.platform.eduservice.entity.EduCourse;
import com.platform.eduservice.service.EduCourseService;
import com.platform.eduservice.entity.EduTeacher;
import com.platform.eduservice.entity.vo.TeacherQuery;
import com.platform.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;


import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author yanwei
 * @since 2021-04-20
 */
@Api(description="讲师管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @Qualifier("eduCourseServiceImpl")
    @Autowired
    private EduCourseService courseService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("item",list);
    }

    @DeleteMapping("{id}")
    public R removeById(@PathVariable String id){
        eduTeacherService.removeById(id);
        return R.ok();
    }

    //3 分页查询讲师的方法
    //current 当前页
    //limit 每页记录数
    @GetMapping("pageTeacher/{current}/{limit}")
    @ApiOperation(value = "分页查询讲师")
    public R pageListTeacher(  @ApiParam(name = "current", value = "当前页", required = true)@PathVariable long current,
                             @PathVariable long limit) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        //调用方法实现分页
        //调用方法时候，底层封装，把分页所有数据封装到pageTeacher对象里面
        eduTeacherService.page(pageTeacher,null);

        long total = pageTeacher.getTotal();//总记录数
        int pages = (int) Math.floor(total / limit);
        List<EduTeacher> records = pageTeacher.getRecords(); //数据list集合
        return R.ok().data("total",total).data("current", current).data("pages",pages+1).data("rows",records);
    }

    //4 条件查询带分页的方法
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,@PathVariable long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);

        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        // mybatis学过 动态sql
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(name)) {
            //构建条件
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create",end);
        }

        //调用方法实现条件查询分页
        eduTeacherService.page(pageTeacher,wrapper);
        long total = pageTeacher.getTotal();//总记录数
        int pages = (int) Math.floor(total / limit);
        List<EduTeacher> records = pageTeacher.getRecords(); //数据list集合
        return R.ok().data("total",total).data("current", current).data("pages",pages+1).data("rows",records);
    }

    //添加讲师接口的方法
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if(save) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    //根据讲师id进行查询
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);

        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id", id);
        System.out.println("###############"+courseService);
        List<EduCourse> list = courseService.list(null);

        return R.ok().data("teacher",eduTeacher).data("courses", list);
    }

    //讲师修改功能
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }


}

