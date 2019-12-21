package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.BaseInfo;
import com.ketai.activity.mapper.BaseInfoMapper;
import com.ketai.activity.query.BaseInfoQuery;
import com.ketai.activity.service.BaseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 研学基地 服务实现类
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
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

        String baseName = baseInfoQuery.getBaseName();

        if(!StringUtils.isEmpty(baseName)){
            queryWrapper.like("baseName",baseName);
        }

        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
