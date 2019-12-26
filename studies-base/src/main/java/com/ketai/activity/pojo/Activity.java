package com.ketai.activity.pojo;

import java.math.BigDecimal;

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
 * 研学活动
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Activity对象", description = "研学活动")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "研学活动主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "研学主题名称")
    @TableField("activityName")
    private String activityName;

    @ApiModelProperty(value = "学校id")
    @TableField("schId")
    private String schId;

    @ApiModelProperty(value = "学校名称")
    @TableField("schName")
    private String schName;

    @ApiModelProperty(value = "学习阶段1小学2初中4高中")
    @TableField("studyStep")
    private Integer studyStep;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "创建人id")
    private String creator;

    @ApiModelProperty(value = "创建人名称")
    @TableField("creatName")
    private String creatName;

    @ApiModelProperty(value = "更新人id")
    private String updator;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "审核状态1未提交2：待学生科审批3：学生科审核拒绝4：待局领导审批5：局领导审核拒绝6：审批已通过")
    @TableField("auditStatus")
    private Integer auditStatus;

    @ApiModelProperty(value = "未通过理由")
    @TableField("reasonsNotPassed")
    private String reasonsNotPassed;

    @ApiModelProperty(value = "基地id")
    @TableField("baseId")
    private String baseId;

    @ApiModelProperty(value = "基地名")
    @TableField("baseName")
    private String baseName;

    @ApiModelProperty(value = "省内外，1省内2省外")
    private Integer province;

    @ApiModelProperty(value = "1:已有基地2：非已有基地")
    @TableField("baseStatus")
    private Integer baseStatus;

    @ApiModelProperty(value = "研学承办机构id")
    @TableField("organizationId")
    private String organizationId;

    @ApiModelProperty(value = "研学承办机构名称")
    @TableField("organizationName")
    private String organizationName;

    @ApiModelProperty(value = "活动开始时间")
    @TableField("serStartTime")
    private Date serStartTime;

    @ApiModelProperty(value = "活动结束时间")
    @TableField("serEndTime")
    private Date serEndTime;

    @ApiModelProperty(value = "负责人姓名")
    @TableField("principalName")
    private String principalName;

    @ApiModelProperty(value = "收费标准")
    private BigDecimal price;

    @ApiModelProperty(value = "合同价")
    @TableField("contractPrice")
    private BigDecimal contractPrice;

    @ApiModelProperty(value = "研学课程目标和涉及的学科")
    @TableField("studiesGoal")
    private String studiesGoal;

    @ApiModelProperty(value = "带队老师人数")
    @TableField("ledTeacherNumber")
    private Integer ledTeacherNumber;

    @ApiModelProperty(value = "随队老师人数")
    @TableField("teamTeacherNumber")
    private Integer teamTeacherNumber;

    @ApiModelProperty(value = "学生人数")
    @TableField("studentNumber")
    private Integer studentNumber;

    @ApiModelProperty(value = "参与年级，多个用，分隔如一年级和二年级   一年级，二年级")
    @TableField("participationSchYear")
    private String participationSchYear;

    @ApiModelProperty(value = "实践表文件 url")
    @TableField("practiceReportChart")
    private String practiceReportChart;

    @ApiModelProperty(value = "实践方案文件 url")
    @TableField("practiceScheme")
    private String practiceScheme;

    @ApiModelProperty(value = "安全承诺书文件 url")
    @TableField("letterOfCommitment")
    private String letterOfCommitment;

    @ApiModelProperty(value = "承办机构合同文件 url")
    @TableField("organizationContract")
    private String organizationContract;

    @ApiModelProperty(value = "贫困生表文件 url")
    @TableField("poorStudentChart")
    private String poorStudentChart;

    @ApiModelProperty(value = "区县id")
    @TableField("organId")
    private String organId;

    @ApiModelProperty(value = "区县名")
    @TableField("organName")
    private String organName;

    @ApiModelProperty(value = "封面图片地址")
    @TableField("imageUrl")
    private String imageUrl;

    @ApiModelProperty(value = "报名开始时间")
    @TableField("signStartTime")
    private Date signStartTime;

    @ApiModelProperty(value = "报名结束时间")
    @TableField("signEndTime")
    private Date signEndTime;

    @ApiModelProperty(value = "活动学年")
    private String schyear;

    @ApiModelProperty(value = "学习阶段别名")
    @TableField("studyStepName")
    private String studyStepName;

    @ApiModelProperty(value = "备用1")
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
