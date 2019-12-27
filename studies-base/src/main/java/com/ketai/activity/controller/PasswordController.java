package com.ketai.activity.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ketai.activity.pojo.ActivitySysUser;
import com.ketai.activity.service.ActivitySysUserService;
import com.ketai.activity.ultil.JwtUtil;
import com.ketai.activity.ultil.SHAUtils;
import constants.ResultCodeEnum;
import entity.Result;
import exception.KetaiException;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;

import java.util.List;
import java.util.Map;

@Api(tags = "系统用户")
@RestController
@RequestMapping("/passport")
public class PasswordController {

    @Autowired
    private ActivitySysUserService activitySysUserService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result login(@ApiParam(name = "accountName", value = "系统用户账号", required = true) @RequestParam String accountName,
                        @ApiParam(name = "password", value = "系统用户密码", required = true) @RequestParam String password) {
        ActivitySysUser SysUser=new ActivitySysUser();
        SysUser.setAccountName(accountName);
        SysUser.setPassword(password);
        ActivitySysUser user = activitySysUserService.findUserVoByUsernameAndPassword(SysUser);
        if (user != null) {
            String token = JwtUtil.getToken(user.getAccountName());
            Map<String,Object> map=new ManagedMap<>();
            map.put("id",user.getId());
            map.put("nickname",user.getNickName());
            map.put("token",token);
            return Result.ok().data(map);
        }
        return Result.error().message("帐号密码错误");
    }

    @PostMapping("/info")
    @ApiOperation(value = "获取用户信息")
    public Result info(
            @ApiParam(name = "token", value = "令牌", required = true)
            @RequestParam String token) throws ServletException {
        Claims claims = JwtUtil.checkToken(token);
        String accoutName = claims.getSubject();
        QueryWrapper<ActivitySysUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("account_name",accoutName);
        Map<String,Object> map=new ManagedMap<>();
        List<ActivitySysUser> list = activitySysUserService.list(queryWrapper);
        for(ActivitySysUser activitySysUser:list){
            map.put("userId",activitySysUser.getId());
            map.put("peopleName",activitySysUser.getNickName());
        }
        return Result.ok().data(map);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "用户登出")
    public Result logout( @ApiParam(name = "token", value = "令牌", required = true)
                          @RequestParam String token) throws ServletException {
        if(token==null){
            throw new KetaiException(ResultCodeEnum.USERUNLOGIN_ERROR);
        }
        Claims claims=JwtUtil.checkToken(token);
        System.out.println(claims);
        return Result.ok();
    }
}
