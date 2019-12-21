package com.ketai.activity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.BaseInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.activity.query.BaseInfoQuery;

import java.util.List;

/**
 * <p>
 * 研学基地 服务类
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
public interface BaseInfoService extends IService<BaseInfo> {
    // 条件查询
    void PageQuery(Page<BaseInfo> pageParam, BaseInfoQuery baseInfoQuery);

}
