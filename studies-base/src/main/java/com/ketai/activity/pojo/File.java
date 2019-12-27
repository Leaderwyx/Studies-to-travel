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
 * 活动照片表
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("activity_file")
@ApiModel(value = "File对象", description = "活动照片表")
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "活动照片表; 主键ID")
    @TableId(value = "id", type = IdType.NONE)
    private String id;

    @ApiModelProperty(value = "activity活动封面 poorStudentChart贫困生表organizationContract承办机构合同,letterOfCommitment安全承诺书,practiceScheme实践方案practiceReportChart实践表文件,record风采")
    private String targetType;

    @ApiModelProperty(value = "(-9999:表示活动默认图片地址)第三方id: activity_id, record_id, ")
    private String targetId;

    @ApiModelProperty(value = "相片地址")
    private String fileUrl;

    @ApiModelProperty(value = "图片尺寸 宽度 像素")
    private Integer width;

    @ApiModelProperty(value = "图片尺寸 高度 像素")
    private Integer height;

    @ApiModelProperty(value = "文件大小 kb")
    private Integer size;

    @ApiModelProperty(value = "0无效1有效")
    private Integer status;

    @ApiModelProperty(value = "创建人user_id")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新人user_id")
    private String updator;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

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
