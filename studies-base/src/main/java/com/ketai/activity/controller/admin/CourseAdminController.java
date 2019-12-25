package com.ketai.activity.controller.admin;

import com.ketai.activity.pojo.CourseInfo;
import com.ketai.activity.service.CourseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 研学课程（新增，修改，删除）相关操作
 *
 * @author Childe Liao
 * @since 2019/12/23
 */
@Api(tags = "研学课程（新增，修改，删除）相关操作")
@RestController
@RequestMapping("/admin/base/course")
public class CourseAdminController {

    @Autowired
    private CourseInfoService courseInfoService;

    @PostMapping("/saveCourseInfo")
    @ApiOperation("保存研学课程服务")
    public Map<String, Object> saveCourseInfo(CourseInfo courseInfo) {
        Map<String, Object> resultMap = resultMap = new HashMap<>(16);
        try {
            boolean b = courseInfoService.saveOrUpdate(courseInfo);
            resultMap.put("code", 20000);
            resultMap.put("success", b);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("error", e.getMessage());
        }
        return resultMap;
    }

}
