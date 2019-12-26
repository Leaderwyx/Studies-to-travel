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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 研学基地 前端控制器
 * </p>
 *
 * @author ChildeXiao
 * @since 2019-12-21
 */
@Api(tags = "研学基地")
@CrossOrigin
@RestController
@RequestMapping("/admin/activity/base-info")
public class BaseInfoAdminController {

    @Autowired
    private BaseInfoService baseInfoService;

    @GetMapping("/{nowPage}/{pageSize}")
    @ApiOperation(value = "根据研学基地名称分页查询研学基地全部信息")
    public Result pageList(
            @ApiParam(name = "nowPage", value = "当前页码", required = true)
            @PathVariable("nowPage") int nowPage,
            @ApiParam(name = "pageSize",value = "每页记录数", required = true)
            @PathVariable("pageSize")int pageSize,
            @ApiParam(name = "baseInfoQuery",value = "查询对象", required = false)
            BaseInfoQuery baseInfoQuery
    ){

        if (nowPage<=0 || pageSize<=0) {
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<BaseInfo> pageParam = new Page<>(nowPage,pageSize);
        baseInfoService.PageQuery(pageParam,baseInfoQuery);
        List<BaseInfo> baseInfoList = pageParam.getRecords();
        return Result.ok().data(new PageResult<BaseInfo>(baseInfoList, pageParam.getPages(), pageParam.getTotal(), nowPage, pageSize));
    }

    @GetMapping("/qryUser")
    @ApiOperation(value = "qryUser")
    public Result qryUser(){
        List<BaseInfo> baseInfoList = baseInfoService.list();
        return Result.ok().data(baseInfoList);
    }

    @GetMapping("/saveBaseInfo")
    @ApiOperation(value = "保存研学基地服务")
    public Result saveBaseInfo(@ApiParam(name = "baseInfo",value = "研究基地添加对象",required = false) BaseInfo baseInfo){
        boolean save = baseInfoService.save(baseInfo);
        if (save) {
            return Result.ok().message("保存成功！");
        }else {
            return Result.error().message("保存失败！");
        }
    }
}

