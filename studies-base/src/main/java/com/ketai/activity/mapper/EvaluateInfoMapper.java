package com.ketai.activity.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.EvaluateInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 研学活动基地评分 Mapper 接口
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Repository
public interface EvaluateInfoMapper extends BaseMapper<EvaluateInfo> {

    IPage<EvaluateInfo> qryEvaluateInfoPage(Page<EvaluateInfo> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
