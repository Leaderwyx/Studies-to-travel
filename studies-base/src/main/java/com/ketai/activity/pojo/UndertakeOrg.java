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
 * 研学承办机构
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UndertakeOrg对象", description = "研学承办机构")
public class UndertakeOrg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "研学承办机构名称")
    private String orgName;

    @ApiModelProperty(value = "机构电话区号")
    private String orgAreaPhone;

    @ApiModelProperty(value = "承办机构电话号码")
    private String orgPhone;

    @ApiModelProperty(value = "区编码")
    private String areaId;

    @ApiModelProperty(value = "区县")
    private String areaName;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "封面照片url地址")
    private String coverPhotoUrl;

    @ApiModelProperty(value = "相册url")
    private String albumUrl;

    @ApiModelProperty(value = "状态; 0无效, 1有效")
    private Boolean status;

    @ApiModelProperty(value = "创建人user_id")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private Integer updator;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "负责人")
    private String responsiblePerson;

    @ApiModelProperty(value = "备用1")
    @TableField(exist = false)
    private Integer standbyInt;

    @ApiModelProperty(value = "备用2")
    @TableField(exist = false)
    private String standbyVarchar;

    @ApiModelProperty(value = "备用3")
    @TableField(exist = false)
    private Date standbyDatetime;

    @ApiModelProperty(value = "备用4")
    @TableField(exist = false)
    private String standbyChar;


}
