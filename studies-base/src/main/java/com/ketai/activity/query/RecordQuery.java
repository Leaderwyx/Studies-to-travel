package com.ketai.activity.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ChildeXiao
 * @version 创建时间：2019/12/23 15:25
 */
@ApiModel(value = "Record查询对象", description = "研学风采查询对象封装")
@Data
public class RecordQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "活动id")
    private String activityId;

    @ApiModelProperty(value = "record活动风采 recordHome 首页8张风采 默认为record")
    private String type;

    @ApiModelProperty(value = "学习阶段1小学2初中4高中")
    private Integer studyStep;

}
