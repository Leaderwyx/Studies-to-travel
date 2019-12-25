package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.BaseInfoMapper;
import com.ketai.activity.mapper.EvaluateInfoMapper;
import com.ketai.activity.pojo.BaseInfo;
import com.ketai.activity.pojo.EvaluateInfo;
import com.ketai.activity.service.EvaluateInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private EvaluateInfoMapper evaluateInfoMapper;
    @Autowired
    private BaseInfoMapper baseInfoMapper;

    @Override
    public IPage<EvaluateInfo> qryEvaluateInfoPage(Page<EvaluateInfo> page, Map<String, Object> map) {
        String baseName = (String) map.get("baseName");
        String startTime = (String) map.get("startTime");
        String endTime = (String) map.get("endTime");
        String qryScore = (String) map.get("qryScore");

        // 通过基地名称获取基地ID
        QueryWrapper<BaseInfo> infoQueryWrapper = new QueryWrapper<>();
        infoQueryWrapper.like(!StringUtils.isEmpty(baseName), "base_name", baseName);
        BaseInfo baseInfo = baseInfoMapper.selectOne(infoQueryWrapper);

        QueryWrapper<EvaluateInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("base_id", baseInfo.getId());
        queryWrapper.between(!(StringUtils.isEmpty(startTime) && StringUtils.isEmpty(endTime)), "create_time", startTime, endTime);
        if (qryScore != null && !StringUtils.isEmpty(qryScore)) {
            queryWrapper.or().eq("safety_score", qryScore)
                    .or().eq("service_score", qryScore)
                    .or().eq("course_score", qryScore)
                    .or().eq("base_manage_score", qryScore)
                    .or().eq("undertake_service_score", qryScore);
        }
        evaluateInfoMapper.selectPage(page, queryWrapper);
        return page;
    }

    @Override
    public Map<String, Object> qryBaseEvaluateGroupCnt(int scoresNum) {
        String colName = "score";
        Map<String, Object> map = new HashMap<>(16);
        for (int i = 0; i < scoresNum; i++) {
            QueryWrapper<EvaluateInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.ge(colName, i).lt(colName, i + 1);
            int score = evaluateInfoMapper.selectCount(queryWrapper);
            map.put(colName + i, score);
        }
        return map;
    }

}
