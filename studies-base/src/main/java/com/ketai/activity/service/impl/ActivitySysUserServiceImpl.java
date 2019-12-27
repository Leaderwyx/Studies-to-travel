package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.ActivitySysUserMapper;
import com.ketai.activity.pojo.ActivitySysUser;
import com.ketai.activity.service.ActivitySysUserService;
import org.springframework.stereotype.Service;

@Service
public class ActivitySysUserServiceImpl extends ServiceImpl<ActivitySysUserMapper, ActivitySysUser> implements ActivitySysUserService {
    @Override
    public ActivitySysUser findUserVoByUsernameAndPassword(ActivitySysUser user) {
        QueryWrapper<ActivitySysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_name", user.getAccountName());
        queryWrapper.eq("password", user.getPassword());
        ActivitySysUser SysUser = (ActivitySysUser) baseMapper.selectOne(queryWrapper);
        if (SysUser != null) {
            return SysUser;
        }
        return null;
    }
}
