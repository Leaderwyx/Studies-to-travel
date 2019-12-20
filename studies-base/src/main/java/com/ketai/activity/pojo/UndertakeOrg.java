package com.ketai.activity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="UndertakeOrg对象", description="研学承办机构")
public class UndertakeOrg implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "id", type = IdType.NONE)
    private Integer id;

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
    private Integer creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private Integer updator;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "负责人")
    private String responsiblePerson;

    private Integer standbyInt;

    private String standbyVarchar;

    private Date standbyDatetime;

    private String standbyChar;


}
