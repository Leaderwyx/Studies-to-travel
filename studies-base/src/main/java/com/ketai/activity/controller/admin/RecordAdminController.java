package com.ketai.activity.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ketai.activity.pojo.Record;
import com.ketai.activity.service.RecordService;
import entity.Result;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 研学风采 前端控制器
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Api(tags = "研学活动风采")
@RestController
@RequestMapping("/admin/record")
public class RecordAdminController {

    @Autowired
    private RecordService recordService;

    @PutMapping("/addRecord")
    @ApiOperation(value = "添加研学风采图片")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "风采ID", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "imageUrl", value = "图片地址", dataType = "String", required = true)
    })
    public Result addRecord(String id, String imageUrl) {
        Record record = new Record();
        record.setImageUrl(imageUrl);
        QueryWrapper<Record> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        boolean save = recordService.saveOrUpdate(record,queryWrapper);
        if (save) {
            return Result.ok().message("图片保存成功！");
        }else {
            return Result.error().message("图片保存失败！");
        }
    }

    @DeleteMapping("/deleteRecord")
    @ApiOperation(value = "删除活动风采")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "风采ID集合多个用,号隔开", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "activityId", value = "活动ID", dataType = "String", required = false)
    })
    public Result deleteRecord(String id,String  activityId){
        boolean b = false;
        String[] split = id.split(",");
        for (int i = 0; i < split.length; i++ ){
            b = recordService.deleteRecord(split[i],activityId);
        }
        if ( b ){
            return Result.ok().message("删除成功！");
        } else  {
            return Result.error().message("删除失败！");
        }
    }

    @PostMapping("/issueRecord")
    @ApiOperation(value = "发布风采")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "activityId", value = "活动ID" ,dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "content", value = "评价内容" ,dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "imageUrl", value = "图片地址" ,dataType = "String", required = true)
    })
    public Result issueRecord(String activityId,String content,String imageUrl){
        Record record = new Record();
        record.setContent(content);
        record.setImageUrl(imageUrl);
        record.setActivityId(activityId);
        boolean save = recordService.save(record);
        if ( save ) {
            return Result.ok().message("发布成功！");
        } else {
            return Result.error().message("发布失败！");
        }
    }
}

