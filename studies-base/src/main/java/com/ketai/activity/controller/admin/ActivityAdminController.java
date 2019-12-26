package com.ketai.activity.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.Activity;
import com.ketai.activity.service.ActivityService;
import entity.PageResult;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 研学活动 前端控制器
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Api(tags = "研学申报")
@RestController
@RequestMapping("/admin/activity/studies")
public class ActivityAdminController {

    @Autowired
    private ActivityService activityService;

    @ApiOperation(value = "获取研学申报表格")
    @GetMapping(value = "/getActivityList/{nowPage}/{pageSize}")
    public Result getActivityList(@PathVariable("nowPage") int nowPage, @PathVariable("pageSize") int pageSize) {
        IPage<Activity> iPage = new Page<>(nowPage, pageSize);
        iPage = activityService.selectPage(iPage);
        return Result.ok().data(new PageResult<>(iPage.getRecords(), iPage.getPages(), iPage.getTotal(), nowPage, pageSize));
    }

}

