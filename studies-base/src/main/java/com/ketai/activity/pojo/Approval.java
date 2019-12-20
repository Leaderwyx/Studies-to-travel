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
 * 审批表
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("activity_approval")
@ApiModel(value = "Approval对象", description = "审批表")
public class Approval implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批表主键")
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    @ApiModelProperty(value = "活动ID")
    private String activityId;

    @ApiModelProperty(value = "审批人身份id")
    private String approverPeopleId;

    @ApiModelProperty(value = "审批人类型")
    private String approverPeopleType;

    @ApiModelProperty(value = "审批人名称")
    private String approveName;

    @ApiModelProperty(value = "审批时间")
    private Date approverTime;

    @ApiModelProperty(value = "0无效1有效")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "创建人userid")
    private String creator;

    @ApiModelProperty(value = "更新人userid")
    private String updator;

    @ApiModelProperty(value = "未通过理由")
    private String reasonsTotPassed;

    @ApiModelProperty(value = "0未通过1已通过")
    private Integer approverStatus;

    @ApiModelProperty(value = "备用1")
    private String standbyOne;

    @ApiModelProperty(value = "备用2")
    private Integer standbyTow;

    @ApiModelProperty(value = "备用3")
    private Date standbyThree;

    @ApiModelProperty(value = "备用4")
    private String standbyFour;

    @ApiModelProperty(value = "备用5")
    private String standbyFive;


}
