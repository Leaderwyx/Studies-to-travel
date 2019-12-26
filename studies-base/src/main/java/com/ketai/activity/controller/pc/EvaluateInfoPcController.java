package com.ketai.activity.controller.pc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ketai.activity.pojo.EvaluateInfo;
import com.ketai.activity.service.EvaluateInfoService;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @功能 研学基地相关操作
 * @author ChildeXiao
 * @version 创建时间：2019/12/25 10:33
 */
@Api(tags = "研学基地相关操作")
@RestController
@RequestMapping("/pc/base/baseManage")
public class EvaluateInfoPcController {

    @Autowired
    private EvaluateInfoService evaluateInfoService;

    @GetMapping("/qryBaseEvaluateInfo")
    @ApiOperation(value = "根据研学基地ID查询研学基地评分信息服务")
    @ApiImplicitParam(paramType = "query", name = "id", value = "研学基地ID", dataType = "String", required = true)
    public Result qryBaseEvaluateInfo(String id) {
        QueryWrapper<EvaluateInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("safety_score","service_score","course_score","base_manage_score","undertake_service_score","score","context");
        queryWrapper.eq("base_id",id);
        EvaluateInfo byId = evaluateInfoService.getOne(queryWrapper);
        return Result.ok().data(byId);
    }

    /**
     * TODO 根据研学基地ID分页查询研学基地评分信息服务
     */

}
