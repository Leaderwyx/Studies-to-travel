package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.BaseInfo;
import com.ketai.activity.mapper.BaseInfoMapper;
import com.ketai.activity.query.BaseInfoQuery;
import com.ketai.activity.service.BaseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 研学基地 服务实现类
 * </p>
 *
 * @author ChildeXiao
 * @since 2019-12-21
 */
@Service
public class BaseInfoServiceImpl extends ServiceImpl<BaseInfoMapper, BaseInfo> implements BaseInfoService {

    @Override
    public void PageQuery(Page<BaseInfo> pageParam, BaseInfoQuery baseInfoQuery) {
        QueryWrapper<BaseInfo> queryWrapper = new QueryWrapper<>();

        if (baseInfoQuery == null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }
        String name = baseInfoQuery.getBaseName();

        String id = baseInfoQuery.getId();
        if (!StringUtils.isEmpty(name)){
            queryWrapper.like("base_name",name);
        }

        if (!StringUtils.isEmpty(id)) {
            queryWrapper.eq("id", id);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }

    @Override
    public BaseInfo findBaseInfoById(String id) {
        QueryWrapper<BaseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        BaseInfo baseInfo = baseMapper.selectOne(queryWrapper);
        return baseInfo;
    }
}
