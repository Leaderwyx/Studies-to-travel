package com.ketai.activity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "RegionShort对象", description = "区县表")
public class RegionShort {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "区县主键")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "区域码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "区县名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "短名称")
    @TableField("short_name")
    private String shortName;

    @ApiModelProperty(value = "区域名称")
    @TableField("region_name")
    private String regionName;

    @ApiModelProperty(value = "地区短名称")
    @TableField("region_short_name")
    private String regionShortName;

    @ApiModelProperty(value = "区域层次")
    @TableField("region_level")
    private Integer regionLevel;

    @ApiModelProperty(value = "父区域码")
    @TableField("parent_code")
    private String parentCode;

    @ApiModelProperty(value = "父id")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "等级2")
    @TableField("level2_id")
    private String level2Id;

    @ApiModelProperty(value = "等级4")
    @TableField("level4_id")
    private String level4Id;



}
