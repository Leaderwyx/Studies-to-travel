package com.ketai.activity.service.impl;

import com.ketai.activity.pojo.BaseInfo;
import com.ketai.activity.mapper.BaseInfoMapper;
import com.ketai.activity.service.BaseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private BaseInfoMapper baseInfoMapper;

    @Override
    public List<BaseInfo> getBaseInfoNameById() {
        List<BaseInfo> baseInfoNameById = baseInfoMapper.getBaseInfoNameById();
        return baseInfoNameById;
    }
}
