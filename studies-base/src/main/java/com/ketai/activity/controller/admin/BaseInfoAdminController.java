package com.ketai.activity.controller.admin;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ketai.activity.pojo.BaseInfo;
import com.ketai.activity.service.BaseInfoService;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 研学基地 前端控制器
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Api(tags = "研学基地接口")
@RestController
@RequestMapping("/studies/admin/base-info")
public class BaseInfoAdminController {

    @Autowired
    private BaseInfoService baseInfoService;

    @ApiOperation(value = "获取所有基地名称")
    @GetMapping("/getBaseInfoName")
    public Result getBaseInfoName() {
        List<BaseInfo> baseInfoNameById = baseInfoService.getBaseInfoNameById();
        return Result.ok().data(baseInfoNameById);
    }

}

