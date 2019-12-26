package com.ketai.activity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 研学报名
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("activity_enroll")
@ApiModel(value = "Enroll对象", description = "研学报名")
public class Enroll implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "研学报名主键")
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    @ApiModelProperty(value = "活动id")
    @TableField("activityId")
    private String activityId;

    @ApiModelProperty(value = "学校ID")
    @TableField("schId")
    private String schId;

    @ApiModelProperty(value = "学校名")
    @TableField("schName")
    private String schName;

    @ApiModelProperty(value = "报名所属人姓名")
    private String name;

    @ApiModelProperty(value = "报名所属人对应id")
    @TableField("peopleId")
    private String peopleId;

    @ApiModelProperty(value = "报名所属人身份类型, 学生为Student, 老师为Teacher")
    @TableField("peopleType")
    private String peopleType;

    @ApiModelProperty(value = "参赛者 班级ID")
    @TableField("classId")
    private String classId;

    @ApiModelProperty(value = "帮报名人身份类型: student, parent, teache（一般为父母）")
    @TableField("crtPeopleType")
    private String crtPeopleType;

    @ApiModelProperty(value = "帮报名人身份id; student_id, parent_id, teacher_id")
    @TableField("crtPeopleId")
    private String crtPeopleId;

    @ApiModelProperty(value = "帮报名人名称")
    @TableField("crtPeopleName")
    private String crtPeopleName;

    @ApiModelProperty(value = "报名状态; 0失败, 1成功")
    private Integer status;

    @ApiModelProperty(value = "创建人user_id")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改人user_id")
    private Integer updator;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "手机号码")
    @TableField("phoneNumber")
    private String phoneNumber;

    @ApiModelProperty(value = "备用1")
    @TableField(exist = false)
    private String standbyOne;

    @ApiModelProperty(value = "备用2")
    @TableField(exist = false)
    private Integer standbyTow;

    @ApiModelProperty(value = "备用3")
    @TableField(exist = false)
    private Date standbyThree;

    @ApiModelProperty(value = "备用4")
    @TableField(exist = false)
    private String standbyFour;

    @ApiModelProperty(value = "备用5")
    @TableField(exist = false)
    private String standbyFive;


}
