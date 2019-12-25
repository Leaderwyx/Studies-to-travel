package com.ketai.activity.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.EvaluateInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

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

    IPage<EvaluateInfo> qryEvaluateInfoPage(Page<EvaluateInfo> page, Map<String, Object> map);

    Map<String, Object> qryBaseEvaluateGroupCnt(int scoresNum);
}
