package com.ketai.activity.pojo;

import com.baomidou.mybatisplus.annotation.*;


import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 研学课程
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Course_info")
@ApiModel(value = "CourseInfo对象", description = "研学课程")
public class CourseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "研学课程主键id")
    private String id;

    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "课程时长")
    private String courseDuration;

    @ApiModelProperty(value = "适合年级")
    private String courseGrade;

    @ApiModelProperty(value = "可参加人数")
    private String courseNum;

    @ApiModelProperty(value = "课程类型")
    private String courseType;

    @ApiModelProperty(value = "封面照片url地址")
    private String coverPhotoUrl;

    @ApiModelProperty(value = "状态; 0无效,1有效")
    private Integer status;

    @ApiModelProperty(value = "创建人user_id")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private String updator;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "所属课程ID")
    private String baseId;

    @ApiModelProperty(value = "详情")
    private String details;


}
