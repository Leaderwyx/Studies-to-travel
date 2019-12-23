package com.ketai.activity.service;

import com.ketai.activity.pojo.BaseInfo;
import com.baomidou.mybatisplus.extension.service.IService;

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

    List<BaseInfo> getBaseInfoNameById();

}
