package com.ketai.activity.controller.admin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.BaseInfo;
import com.ketai.activity.query.BaseInfoQuery;
import com.ketai.activity.service.BaseInfoService;
import constants.ResultCodeEnum;
import entity.PageResult;
import entity.Result;
import exception.KetaiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(tags = "研学基地")
@RestController
@RequestMapping("/admin/activity/base-info")
public class BaseInfoAdminController {

    @Autowired
    private BaseInfoService baseInfoService;

    @PostMapping("/{pageSize}/{currentPage}")
    @ApiOperation(value = "根据研学基地名称分页查询研学基地全部信息")
    public Result pageList(
            @ApiParam(name = "pageSize", value = "当前页码", required = true)
            @PathVariable("pageSize") Long pageSize,
            @ApiParam(name = "currentPage",value = "每页记录数", required = true)
            @PathVariable("currentPage")Long currentPage,
            @ApiParam(name = "baseInfoQuery",value = "查询对象", required = false)
            BaseInfoQuery baseInfoQuery
    ){
        PageResult<BaseInfo> pageResult = new PageResult<>();
        if (pageSize<=0 || currentPage<=0) {
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<BaseInfo> pageParam = new Page<>(pageSize,currentPage);
        baseInfoService.PageQuery(pageParam,baseInfoQuery);
        List<BaseInfo> records = pageParam.getRecords();
        //获取总记录数

        long total = pageParam.getTotal();
        List<BaseInfo> baseInfoList = baseInfoService.list();
        return Result.ok().data("records",records).data("total",total);
    }


}

