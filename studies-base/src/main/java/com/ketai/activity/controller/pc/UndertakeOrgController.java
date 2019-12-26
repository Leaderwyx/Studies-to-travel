package com.ketai.activity.controller.pc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.Activity;
import com.ketai.activity.pojo.EvaluateInfo;
import com.ketai.activity.pojo.UndertakeOrg;
import com.ketai.activity.service.ActivityService;
import com.ketai.activity.service.EvaluateInfoService;
import com.ketai.activity.service.UndertakeOrgService;
import com.ketai.activity.vo.UndertakeOrgEvaluateVo;
import entity.PageResult;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 研学承办机构相关操作
 *
 * @author Childe Liao
 * @since 2019/12/25
 */
@Api(tags = "研学承办机构相关操作")
@RestController
@RequestMapping("/pc/base/undertakeOrg")
public class UndertakeOrgController {

    @Autowired
    private EvaluateInfoService evaluateInfoService;
    @Autowired
    private UndertakeOrgService undertakeOrgService;
    @Autowired
    private ActivityService activityService;

    @PostMapping("/qryUndertakeOrgEvaluateInfo")
    @ApiOperation("查询根据研学承办机构ID查询研学承办机构评分信息服务")
    @ApiImplicitParam(paramType = "query", name = "id", value = "研学承办机构id", dataType = "int")
    public Result qryUndertakeOrgEvaluateInfo(Integer id) {
        QueryWrapper<EvaluateInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("ROUND(AVG(`safety_score`)) safety_score", "ROUND(AVG(`service_score`)) service_score",
                "ROUND(AVG(`course_score`)) course_score", "ROUND(AVG(`base_manage_score`)) base_manage_score",
                "ROUND(AVG(`undertake_service_score`)) undertake_service_score", "ROUND(AVG(score)) score", "display", "status");
        queryWrapper.eq((id != null && id != 0),"undertake_org_id", id);
        queryWrapper.groupBy("display", "status");
        EvaluateInfo evaluateInfo = evaluateInfoService.getOne(queryWrapper);
        Map<String, Object> map = new HashMap<>(16);
        map.put("context", "");
        map.put("safetyScore", evaluateInfo.getSafetyScore());
        map.put("serviceScore", evaluateInfo.getServiceScore());
        map.put("courseScore", evaluateInfo.getCourseScore());
        map.put("baseManageScore", evaluateInfo.getBaseManageScore());
        map.put("undertakeServiceScore", evaluateInfo.getUndertakeServiceScore());
        map.put("score", evaluateInfo.getScore());
        map.put("display", evaluateInfo.getDisplay());
        map.put("status", evaluateInfo.getStatus());
        return Result.ok().data(map);
    }

    @PostMapping("/qryUndertakeOrgEvaluatePage")
    @ApiOperation("查询根据承办机构ID分页查询研学承办机构评分信息服务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nowPage", value = "当前页", dataType = "int", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页大小", dataType = "int", required = true),
            @ApiImplicitParam(paramType = "query", name = "undertakeOrgId", value = "研学承办机构ID", dataType = "int")
    })
    public Result qryUndertakeOrgEvaluatePage(int nowPage, int pageSize, Integer undertakeOrgId) {
        QueryWrapper<EvaluateInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq((undertakeOrgId != null && undertakeOrgId != 0),"undertake_org_id", undertakeOrgId);
        Page<EvaluateInfo> page = evaluateInfoService.page(new Page<>(nowPage, pageSize), queryWrapper);

        List<UndertakeOrgEvaluateVo> list = new ArrayList<>();
        for (EvaluateInfo record : page.getRecords()) {
            UndertakeOrgEvaluateVo undertakeOrgEvaluateVo = new UndertakeOrgEvaluateVo();
            BeanUtils.copyProperties(record, undertakeOrgEvaluateVo);
            list.add(undertakeOrgEvaluateVo);
        }
        return Result.ok().data(new PageResult<>(list, page.getPages(), page.getTotal(), nowPage, pageSize));
    }

    @PostMapping("/qryUndertakeOrgInfo")
    @ApiOperation("查询根据研学承办机构ID查询研学承办机构服务")
    @ApiImplicitParam(paramType = "query", name = "id", value = "研学承办机构id", dataType = "int")
    public Result qryUndertakeOrgInfo(Integer id) {
        QueryWrapper<UndertakeOrg> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq((id != null && id != 0),"id", id);
        UndertakeOrg undertakeOrg = undertakeOrgService.getOne(queryWrapper);
        return Result.ok().data(undertakeOrg);
    }

    @PostMapping("/qryUndertakeOrgInfoActivityPage")
    @ApiOperation("分页查询研学承办机构服务(包括实践活动次数)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "orgname", value = "区域名称"),
            @ApiImplicitParam(paramType = "query", name = "id", value = "承办机构ID", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "nowPage", value = "当前页", dataType = "int", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页大小", dataType = "int", required = true)
    })
    public Result qryUndertakeOrgInfoActivityPage(String orgname, Integer id, int nowPage, int pageSize) {
        QueryWrapper<UndertakeOrg> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq((id != null && id != 0),"id", id);
        // TODO 对区县做动态添加查询
        // where id = 1
        Page<UndertakeOrg> page = undertakeOrgService.page(new Page<>(nowPage, pageSize), queryWrapper);

        QueryWrapper<Activity> activityQueryWrapper = new QueryWrapper<>();
        // select COUNT(organizationId) actCnt, organizationId from Activity group By organizationId
        // actCnt | organizationId
        // 10     | 123214
        // 1      | 678890
        activityQueryWrapper.select("COUNT(organizationId) actCnt, organizationId").groupBy("organizationId");
        List<Map<String, Object>> maps = activityService.listMaps(activityQueryWrapper);
        for (UndertakeOrg record : page.getRecords()) {
            for (Map<String, Object> map : maps) {
                if (record.equals(map.get("organizationId"))) {
                    record.setActCnt((Integer) map.get("actCnt"));
                }
            }
        }
        return Result.ok().data(new PageResult<>(page.getRecords(), page.getPages(), page.getTotal(), nowPage, pageSize));
    }

    @PostMapping("/qryUndertakeOrgInfoPage")
    @ApiOperation("分页查询研学承办机构服务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "orgname", value = "区域名称"),
            @ApiImplicitParam(paramType = "query", name = "id", value = "承办机构ID", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "nowPage", value = "当前页", dataType = "int", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页大小", dataType = "int", required = true)
    })
    public Result qryUndertakeOrgInfoPage(String orgname, Integer id, int nowPage, int pageSize) {
        QueryWrapper<UndertakeOrg> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq((id != null && id != 0),"id", id);
        // TODO 对区县做动态添加查询
        Page<UndertakeOrg> page = undertakeOrgService.page(new Page<>(nowPage, pageSize), queryWrapper);
        return Result.ok().data(new PageResult<>(page.getRecords(), page.getPages(), page.getTotal(), nowPage, pageSize));
    }

}
