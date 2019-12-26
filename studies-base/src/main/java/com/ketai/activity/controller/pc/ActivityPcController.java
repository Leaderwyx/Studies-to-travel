package com.ketai.activity.controller.pc;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.*;
import com.ketai.activity.service.*;
import constants.ResultCodeEnum;
import entity.PageResult;
import entity.Result;
import exception.KetaiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 研学活动 前端控制器
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Api(tags = "研学活动")
@RestController
@RequestMapping("/pc/activity/activity")
public class ActivityPcController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private EvaluateInfoService evaluateInfoService;

    @Autowired
    private BaseInfoService baseInfoService;

    @Autowired
    private RegionShortService regionShortService;

    @Autowired
    private UndertakeOrgService undertakeOrgService;

    @GetMapping("/{id}")
    @ApiOperation(value = "活动详情")
    public Result pageList(@ApiParam(name = "id", value = "活动id", required = true)@PathVariable("id") String id){
        Map<String,Object> map = new HashMap<>();

        //研学活动详情
        Activity activityByid = activityService.findActivityById(id);
        map.put("activityModel",activityByid);

        //研学活动基地评分详情
        EvaluateInfo evaluateInfoByid = evaluateInfoService.findEvaluateInfoById(id);
        map.put("valuateInfoModel",evaluateInfoByid);

        //取出基地id
        String baseId = evaluateInfoByid.getBaseId();
        //研学基地详情
        BaseInfo baseInfoById = baseInfoService.findBaseInfoById(baseId);
        map.put("baseInfoModelWithBLOBs",baseInfoById);

        return Result.ok().data(map);

    }

    @GetMapping("/schyearList")
    @ApiOperation(value = "得到所有的活动学年")
    public Result schyearList(){
        List<String> schyearList = activityService.schyearList();
        return Result.ok().data(schyearList);
    }

    @GetMapping("/getSelectItem")
    @ApiOperation(value = "得到筛选项")
    public Result getSelectItem(){
        List<RegionShort> regionShortList = regionShortService.list();
        List<BaseInfo> baseInfoList = baseInfoService.list();
        List<UndertakeOrg> undertakeOrgList = undertakeOrgService.list();
        Map<String, Object> map = new HashMap<>();
        map.put("organs",regionShortList);
        map.put("baseInfo",baseInfoList);
        // TODO myphone字段找不在哪里
        map.put("undertakeOrgModels",undertakeOrgList);
        return Result.ok().data(map);
    }

    @GetMapping("/{nowPage}/{pageSize}")
    @ApiOperation(value = "研学活动分页查找")
    public Result activityPageList(
            @ApiParam(name = "nowPage", value = "当前页码",required = true)
            @PathVariable("nowPage") int nowPage,
            @ApiParam(name = "pageSize",value = "每页记录数", required = true)
            @PathVariable("pageSize")int pageSize,
            @ApiParam(name = "activity",value = "查询对象", required = false) Activity activity){
        if (nowPage<=0 || pageSize<=0) {
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<Activity> pageParam = new Page<>(nowPage,pageSize);
        activityService.activityPageQueryList(pageParam,activity);
        List<Activity> records = pageParam.getRecords();
        return Result.ok().data(new PageResult<Activity>(records, pageParam.getPages(), pageParam.getTotal(), nowPage, pageSize));
    }



}

