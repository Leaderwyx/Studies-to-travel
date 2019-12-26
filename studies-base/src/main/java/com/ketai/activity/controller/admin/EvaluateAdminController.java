package com.ketai.activity.controller.admin;

import annotation.ApiJsonObject;
import annotation.ApiJsonProperty;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.EvaluateInfo;
import com.ketai.activity.service.EvaluateInfoService;
import entity.PageResult;
import entity.Result;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 研学评分相关操作
 *
 * @author Childe Liao
 * @since 2019/12/24
 */
@Api(tags = "研学评分相关操作")
@RestController
@RequestMapping("/admin/base/evaluate")
public class EvaluateAdminController {

    @Autowired
    private EvaluateInfoService evaluateInfoService;

    @PostMapping("/changeEvaluateState")
    @ApiOperation(value = "显示/隐藏研学评分")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "研学评分ID", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "display", value = "是否显示:1显示,0隐藏", dataType = "String")
    })
    public Result changeEvaluateState(String id, String display) {
        UpdateWrapper<EvaluateInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("display", display);
        updateWrapper.eq("id", id);
        boolean update = evaluateInfoService.update(updateWrapper);
        return Result.ok().success(update);
    }

    @PostMapping("/qryBaseEvaluateGroupCnt")
    @ApiOperation(value = "查询研学基地评分每组评分数量统计")
    public Result qryBaseEvaluateGroupCnt() {
        Map<String, Object> map = evaluateInfoService.qryBaseEvaluateGroupCnt(6);
        return Result.ok().data(map);
    }

    @PostMapping("/qryBaseEvaluatePage")
    @ApiOperation(value = "根据基地名称分页查询研学基地评分信息服务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "baseId", value = "研学基地ID"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页大小", dataType = "int", required = true),
            @ApiImplicitParam(paramType = "query", name = "nowPage", value = "当前页", dataType = "int", required = true)
    })
    public Result qryBaseEvaluatePage(String baseId, int pageSize, int nowPage) {
        Page<EvaluateInfo> infoPage = new Page<>(nowPage, pageSize);
        QueryWrapper<EvaluateInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!StringUtils.isEmpty(baseId), "base_id", baseId);
        evaluateInfoService.page(infoPage, queryWrapper);
        return Result.ok().data(new PageResult<>(infoPage.getRecords(), infoPage.getPages(), infoPage.getTotal(), nowPage, pageSize));
    }

    @PostMapping("/qryEvaluateInfoPage")
    @ApiOperation(value = "待测试---分页查询研学评分")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页大小", dataType = "int", required = true),
            @ApiImplicitParam(paramType = "query", name = "nowPage", value = "当前页", dataType = "int", required = true),
    })
    public Result qryEvaluateInfoPage(int pageSize, int nowPage, @RequestBody Map<String, Object> params) {
        IPage<EvaluateInfo> infoIPage = evaluateInfoService.qryEvaluateInfoPage(new Page<>(nowPage, pageSize), params);
        return Result.ok().data(new PageResult<>(infoIPage.getRecords(), infoIPage.getPages(), infoIPage.getTotal(), nowPage, pageSize));
    }

}
