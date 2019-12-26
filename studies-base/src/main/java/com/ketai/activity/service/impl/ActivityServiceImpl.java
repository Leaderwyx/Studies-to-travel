package com.ketai.activity.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.Activity;
import com.ketai.activity.mapper.ActivityMapper;
import com.ketai.activity.service.ActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Activity findActivityById(String id) {
        Activity activity = baseMapper.selectById(id);
        return activity;
    }

    @Override
    @Cacheable(value = "schyear", key="T(String).valueOf('schyearList')")
    public List<String> schyearList() {
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("schyear");
        List<Activity> schyearActivities = activityMapper.selectList(queryWrapper);
        List<String> collect = schyearActivities.stream().map(Activity::getSchyear).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void activityPageQueryList(Page<Activity> pageParam, Activity activity) {
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();

        if (activity == null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }
        queryWrapper.eq(!StringUtils.isEmpty(activity.getId()),"id",activity.getId());
        queryWrapper.like(!StringUtils.isEmpty(activity.getActivityName()),"activityName",activity.getActivityName());
        queryWrapper.eq(!StringUtils.isEmpty(activity.getSchId()),"schId",activity.getSchId());
        queryWrapper.like(!StringUtils.isEmpty(activity.getSchName()),"schName",activity.getSchName());
        queryWrapper.eq(!StringUtils.isEmpty(activity.getStudyStep()),"studyStep",activity.getStudyStep());
        queryWrapper.like(!StringUtils.isEmpty(activity.getCreatName()),"creatName",activity.getCreatName());
        queryWrapper.like(!StringUtils.isEmpty(activity.getCreateTime()),"createTime",activity.getCreateTime());
        queryWrapper.eq(!StringUtils.isEmpty(activity.getAuditStatus()),"auditStatus   ",activity.getAuditStatus());
        queryWrapper.like(!StringUtils.isEmpty(activity.getReasonsNotPassed()),"reasonsNotPassed",activity.getReasonsNotPassed());
        queryWrapper.eq(!StringUtils.isEmpty(activity.getBaseId()),"baseId",activity.getBaseId());
        queryWrapper.like(!StringUtils.isEmpty(activity.getBaseName()),"baseName",activity.getBaseName());
        queryWrapper.eq(!StringUtils.isEmpty(activity.getProvince()),"province",activity.getProvince());
        queryWrapper.eq(!StringUtils.isEmpty(activity.getBaseStatus()),"baseStatus",activity.getBaseStatus());
        queryWrapper.eq(!StringUtils.isEmpty(activity.getOrganizationId()),"organizationId",activity.getOrganizationId());
        queryWrapper.like(!StringUtils.isEmpty(activity.getOrganizationName()),"organizationName",activity.getOrganizationName());
        queryWrapper.like(activity.getSerStartTime()!=null,"serStartTime",activity.getSerStartTime());
        queryWrapper.like(activity.getSerEndTime()!=null,"serEndTime",activity.getSerEndTime());
        queryWrapper.like(!StringUtils.isEmpty(activity.getPrincipalName()),"principalName",activity.getPrincipalName());
        queryWrapper.like(!StringUtils.isEmpty(activity.getPrice()),"price",activity.getPrice());

        baseMapper.selectPage(pageParam,queryWrapper);

    }


}
