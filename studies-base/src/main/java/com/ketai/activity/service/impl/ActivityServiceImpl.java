package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ketai.activity.pojo.Activity;
import com.ketai.activity.mapper.ActivityMapper;
import com.ketai.activity.service.ActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 研学活动 服务实现类
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    public IPage<Activity> selectPage(IPage<Activity> iPage){
        IPage<Activity> activityIPage = activityMapper.selectPage(iPage, null);
        return activityIPage;
    }

}
