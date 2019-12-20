package com.ketai.activity.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
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
 * 研学活动基地评分
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Evaluate_info")
@ApiModel(value="EvaluateInfo对象", description="研学活动基地评分")
public class EvaluateInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "研学活动基地评分表")
      @TableId(value = "id", type = IdType.NONE)
    private String id;

    @ApiModelProperty(value = "评分内容")
    private String context;

    @ApiModelProperty(value = "本次基地id")
    private String baseId;

    @ApiModelProperty(value = "本次活动id")
    private String activityId;

    @ApiModelProperty(value = "安全措施评分1-5分")
    private BigDecimal safetyScore;

    @ApiModelProperty(value = "服务态度评分（1-5分）")
    private BigDecimal serviceScore;

    @ApiModelProperty(value = "研学课程评分（1-5分）")
    private BigDecimal courseScore;

    @ApiModelProperty(value = "基地管理评分（1-5分）")
    private BigDecimal baseManageScore;

    @ApiModelProperty(value = "承办机构服务态度评分（1-5分）")
    private BigDecimal undertakeServiceScore;

    @ApiModelProperty(value = "总评分（前面五项算平均分，四舍五入保留小数点一位）")
    private BigDecimal score;

    @ApiModelProperty(value = "所属学校ID")
    private String schoolId;

    @ApiModelProperty(value = "显示1；隐藏0")
    private String display;

    @ApiModelProperty(value = "状态; 0无效, 1有效")
    private Boolean status;

    @ApiModelProperty(value = "创建人user_id")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private String updator;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "承办机构ID")
    private String undertakeOrgId;

    @ApiModelProperty(value = "评分人ID")
    private String peopleId;

    @ApiModelProperty(value = "评分人类型")
    private String peopleType;

    @ApiModelProperty(value = "评分人姓名")
    private String peopleName;

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
