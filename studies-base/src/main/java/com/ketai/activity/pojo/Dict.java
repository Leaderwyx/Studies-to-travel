package com.ketai.activity.pojo;

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
 * 字典
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Dict对象", description="字典")
public class Dict implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "字典表主键ID")
      @TableId(value = "id", type = IdType.NONE)
    private String id;

    @ApiModelProperty(value = "类型")
    private String dicType;

    @ApiModelProperty(value = "名称")
    private String dicName;

    @ApiModelProperty(value = "编号")
    private Integer dicCode;

    @ApiModelProperty(value = "描述")
    private String dicDesc;

    @ApiModelProperty(value = "排序")
    private Integer orderBy;

    @ApiModelProperty(value = "是否删除 0：否；1：是")
    private Integer isDelete;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private String updator;

    @ApiModelProperty(value = "更新时间")
      @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
