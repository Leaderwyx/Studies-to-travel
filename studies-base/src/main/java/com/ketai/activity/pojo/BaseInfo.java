package com.ketai.activity.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 研学基地
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "BaseInfo对象", description = "研学基地")
public class BaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "基地名称")
    private String baseName;

    @ApiModelProperty(value = "基地标签，从 yx_dic表读取，多个值用逗号分隔")
    private String baseTags;

    @ApiModelProperty(value = "基地类型（1省内，2省外）")
    private String baseType;

    @ApiModelProperty(value = "基地电话区号")
    private String baseAreaphone;

    @ApiModelProperty(value = "基地电话号码")
    private String basePhone;

    @ApiModelProperty(value = "区编码")
    private String areaId;

    @ApiModelProperty(value = "区县")
    private String areaName;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "封面照片url地址")
    private String coverPhotourl;

    @ApiModelProperty(value = "相册url")
    private String albumUrl;

    @ApiModelProperty(value = "状态; 0无效, 1有效")
    private Integer status;

    @ApiModelProperty(value = "创建人user_id")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private String updator;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "负责人")
    private String responsiblePerson;

    @ApiModelProperty(value = "基地简介")
    private String baseProfile;

    @ApiModelProperty(value = "基地详情")
    private String baseDetails;

    @ApiModelProperty(value = "备用字段3")
    @TableField(exist = false)
    private Double alternate3;

    @ApiModelProperty(value = "备用字段4")
    @TableField(exist = false)
    private Date alternate4;

    @ApiModelProperty(value = "备用字段5")
    @TableField(exist = false)
    private Long alternate5;


}
