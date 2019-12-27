package com.ketai.activity.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ketai.activity.pojo.ActivitySysUser;
import com.ketai.activity.pojo.File;
import com.ketai.activity.service.FileService;
import com.ketai.activity.ultil.JwtUtil;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/saggertest")
public class SwaggerSampleController {
    @Autowired
    private FileService fileService;

    @PostMapping
    @ApiOperation(value = "接口test")
    public Result saggertestTest(@ApiParam(name = "param1", value = "参数说明1", required = true) @RequestParam(defaultValue = "0") String param1,
                                 @ApiParam(name = "id", value = "活动照片表; 主键ID", required = true) @RequestParam(defaultValue = "0") String id,
                                 @ApiParam(name = "targetType", value = "activity 活动封面 poorStudentChart贫困生表organizationContract承办机构合同,letterOfCommitment安全承诺书,practiceScheme实践方案practiceReportChart实践表文件,record风采", required = true) @RequestParam(defaultValue = "0") String targetType,
                                 @ApiParam(name = "targetId", value = "(-9999:表示活动默认图片地址)第三方id: activity_id, record_id, ", required = true) @RequestParam(defaultValue = "0") String targetId,
                                 @ApiParam(name = "fileUrl", value = "相片地址", required = true) @RequestParam(defaultValue = "0") String fileUrl,
                                 @ApiParam(name = "width", value = "图片尺寸 宽度 像素", required = true) @RequestParam(defaultValue = "0") String width,
                                 @ApiParam(name = "height", value = "图片尺寸 高度 像素", required = true) @RequestParam(defaultValue = "0") String height,
                                 @ApiParam(name = "size", value = "文件大小 kb", required = true) @RequestParam(defaultValue = "0") String size) {
        QueryWrapper<File> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        queryWrapper.eq("target_type",targetType);
        queryWrapper.eq("target_id",targetId);
        queryWrapper.eq("file_url",fileUrl);
        queryWrapper.eq("width",width);
        queryWrapper.eq("height",height);
        queryWrapper.eq("size",size);
        List<File> list = fileService.list(queryWrapper);
       return Result.ok().data(list);
    }

}
