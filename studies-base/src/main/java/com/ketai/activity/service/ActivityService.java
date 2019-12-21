package com.ketai.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ketai.activity.pojo.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 研学活动 服务类
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
public interface ActivityService extends IService<Activity> {

    public IPage<Activity> selectPage(IPage<Activity> iPage);

}
