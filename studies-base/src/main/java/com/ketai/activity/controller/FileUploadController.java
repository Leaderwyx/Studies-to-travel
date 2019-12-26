package com.ketai.activity.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.ketai.activity.service.FileUploadService;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.ConstantPropertiesUtil;

/**
 * <p>
 * 文件上传 前端控制器
 * </p>
 * @author ChildeXiao
 * @version 创建时间：2019/12/23 10:37
 */
@Api(tags = "阿里云文件管理")
@RestController
@RequestMapping("/oss/file")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public Result upload(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file,
            @ApiParam(name = "host", value = "文件上传路径", required = false)
            @RequestParam(value = "host", required = false) String host){
        if(!StringUtils.isEmpty(host)){
            ConstantPropertiesUtil.FILE_HOST = host;
        }

        String uploadUrl = fileUploadService.upload(file);
        System.out.println("图片地址:"+uploadUrl);
        //返回r对象
        return Result.ok().message("文件上传成功").data(uploadUrl);
    }
}
