package com.ketai.activity.controller.pc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.CourseInfo;
import com.ketai.activity.service.CourseInfoService;
import entity.PageResult;
import entity.Result;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 研学课程相关操作
 *
 * @author Childe Liao
 * @since 2019/12/23
 */
@Api(tags = "研学课程相关操作")
@RestController
@RequestMapping("/pc/base/course")
public class CourseController {

    @Autowired
    private CourseInfoService courseInfoService;

    @PostMapping("/qryCourseInfo")
    public Result getCourseInfoById(Integer id) {
        CourseInfo courseInfo = courseInfoService.getById(id);
        return Result.ok().data(courseInfo);
    }

    @PostMapping("/qryCourseInfoPage")
    public Result getPageCourseInfoById(String courseName, int pageSize, int nowPage) {
        // 查询条件
        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(courseName), "course_name", courseName);
        // 查询
        Page<CourseInfo> courseInfoPage = new Page<>(nowPage, pageSize);
        courseInfoService.page(courseInfoPage, queryWrapper);
        // 封装并返回
        List<CourseInfo> datalist = courseInfoPage.getRecords();
        long pages = courseInfoPage.getPages();
        long total = courseInfoPage.getTotal();
        return Result.ok().data(new PageResult<>(datalist, pages, total, nowPage, pageSize));
    }

}
