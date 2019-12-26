package com.ketai.activity.controller.pc;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.Record;
import com.ketai.activity.query.RecordQuery;
import com.ketai.activity.service.RecordService;
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
 * 研学风采 前端控制器
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Api(tags = "研学风采")
@RestController
@RequestMapping("/pc/activity/record")
public class RecordPcController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/{nowPage}/{pageSize}")
    @ApiOperation(value = "条件分页查询研学风采")
    public Result recordPageList(
            @ApiParam(name = "nowPage", value = "当前页码", required = true)
            @PathVariable("nowPage") int nowPage,
            @ApiParam(name = "pageSize",value = "每页记录数", required = true)
            @PathVariable("pageSize")int pageSize,
            @ApiParam(name = "baseInfoQuery",value = "查询对象", required = false) RecordQuery recordQuery
    ){
        if (nowPage<=0 || pageSize<=0) {
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<Record> pageParam = new Page<>(nowPage,pageSize);
        recordService.findActivityRecordList(pageParam,recordQuery);
        List<Record> records = pageParam.getRecords();
        return Result.ok().data(new PageResult<Record>(records, pageParam.getPages(), pageParam.getTotal(), nowPage, pageSize));
    }

}

