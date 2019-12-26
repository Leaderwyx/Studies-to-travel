package com.ketai.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 研学活动 服务类
 * </p>
 *
 * @author ChildeXiao
 * @since 2019-12-20
 */
public interface ActivityService extends IService<Activity> {

   IPage<Activity> selectPage(IPage<Activity> iPage);

    /**
     * 研学活动条件查询
     * @param id
     */
    Activity findActivityById(String id);

    /**
     * 得到所有的活动学年
     * @return
     */
   List<String> schyearList();

    /**
     * 研学活动条件查询
     * @param pageParam
     * @param activity
     */
    void activityPageQueryList(Page<Activity> pageParam, Activity activity);

}
