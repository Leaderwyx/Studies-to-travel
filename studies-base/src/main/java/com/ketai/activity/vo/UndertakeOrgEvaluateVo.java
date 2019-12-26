package com.ketai.activity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 研学承办机构评分VO
 *
 * @author Childe Liao
 * @since 2019/12/25
 */
@Data
@ApiModel(value = "UndertakeOrgEvaluateVo对象", description = "研学承办机构评分")
public class UndertakeOrgEvaluateVo implements Serializable {

    @ApiModelProperty(value = "评分内容")
    private String context;

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

    @ApiModelProperty(value = "显示1；隐藏0")
    private String display;

    @ApiModelProperty(value = "状态; 0无效, 1有效")
    private Boolean status;

    @ApiModelProperty(value = "创建人user_id")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "评分人ID")
    private String peopleId;

    @ApiModelProperty(value = "评分人姓名")
    private String peopleName;

    @ApiModelProperty(value = "评分人头像URL")
    private String peopleHeadImgUrl;

}
