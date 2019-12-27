package com.ketai.activity.controller.pc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ketai.activity.pojo.EvaluateInfo;
import com.ketai.activity.pojo.RegionShort;
import com.ketai.activity.service.RegionShortService;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pc/orgChildList")
public class OrgController {
    @Autowired
    private RegionShortService regionShortService;


    @RequestMapping("/{parentCode}")
    @ApiOperation(value = "根据父区域码查询")
    public Result RegionShortselect( @ApiParam(name = "parentCode", value = "父区域码", required = true)
                                       @PathVariable String parentCode) {
        QueryWrapper<RegionShort> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_code",parentCode);
        List<RegionShort> list = regionShortService.list(queryWrapper);
        return Result.ok().data(list);
    }
}
