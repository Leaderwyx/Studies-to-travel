package com.ketai.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.EvaluateInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.activity.pojo.EvaluateInfo;

import java.util.Map;

/**
 * <p>
 * 研学活动基地评分 服务类
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
public interface EvaluateInfoService extends IService<EvaluateInfo> {

    IPage<EvaluateInfo> qryEvaluateInfoPage(Page<EvaluateInfo> page, String baseName, String startTime, String endTime, String qryScore);
    /**
     * 研学活动基地评分条件查询
     * @param id
     */
    EvaluateInfo findEvaluateInfoById(String id);

    Map<String, Object> qryBaseEvaluateGroupCnt(int scoresNum);
}
