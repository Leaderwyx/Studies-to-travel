package com.ketai.activity.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.pojo.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ketai.activity.query.RecordQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 研学风采 Mapper 接口
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
public interface RecordMapper extends BaseMapper<Record> {

    /**
     * 条件查询研学风采信息
     * @param recordQuery
     * @return
     */
    IPage<Record> findActivityRecordList(Page<Record> pageParam,@Param("recordQuery") RecordQuery recordQuery);

    boolean deleteRecord(@Param("id") String id,@Param("activityId") String  activityId);

}
