package com.ketai.activity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ketai.activity.pojo.BaseInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 研学基地 Mapper 接口
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Repository
public interface BaseInfoMapper extends BaseMapper<BaseInfo> {

    List<BaseInfo> getBaseInfoNameById();

}
