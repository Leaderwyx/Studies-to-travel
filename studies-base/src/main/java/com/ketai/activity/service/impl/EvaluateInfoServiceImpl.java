package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ketai.activity.pojo.EvaluateInfo;
import com.ketai.activity.mapper.EvaluateInfoMapper;
import com.ketai.activity.service.EvaluateInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 研学活动基地评分 服务实现类
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Service
public class EvaluateInfoServiceImpl extends ServiceImpl<EvaluateInfoMapper, EvaluateInfo> implements EvaluateInfoService {

    @Override
    public EvaluateInfo findEvaluateInfoById(String id) {

        QueryWrapper<EvaluateInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("activity_id",id);

        EvaluateInfo evaluateInfo = baseMapper.selectOne(queryWrapper);
        return evaluateInfo;
    }
}
