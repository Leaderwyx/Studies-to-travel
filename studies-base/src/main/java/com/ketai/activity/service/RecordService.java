package com.ketai.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.Record;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.activity.query.RecordQuery;

/**
 * <p>
 * 研学风采 服务类
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
public interface RecordService extends IService<Record> {

    /**
     * 条件查询研学风采信息
     * @param recordQuery
     * @return
     */
    IPage<Record> findActivityRecordList(Page<Record> pageParam, RecordQuery recordQuery);

    /**
     * 根据活动ID删除风采
     * @param id
     * @param activityId
     * @return
     */
    boolean deleteRecord(String id, String  activityId);


}
