package com.ketai.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.activity.pojo.Activity;
import com.ketai.activity.pojo.ActivitySysUser;

import java.util.List;

/**
 * <p>
 * 系统用户 用户类
 * </p>
 *
 * @author dengzongle
 * @since 2019-12-20
 */
public interface ActivitySysUserService extends IService<ActivitySysUser> {
    ActivitySysUser findUserVoByUsernameAndPassword(ActivitySysUser user);
}
