package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.Record;
import com.ketai.activity.mapper.RecordMapper;
import com.ketai.activity.query.RecordQuery;
import com.ketai.activity.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 研学风采 服务实现类
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public IPage<Record> findActivityRecordList(Page<Record> pageParam, RecordQuery recordQuery) {

        return recordMapper.findActivityRecordList(pageParam, recordQuery);

    }

    @Override
    public boolean deleteRecord(String id, String activityId) {
        return recordMapper.deleteRecord(id,activityId);
    }
}
