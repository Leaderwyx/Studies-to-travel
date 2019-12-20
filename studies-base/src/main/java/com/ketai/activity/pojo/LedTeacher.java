package com.ketai.activity.pojo;

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
 * 研学带队老师
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("activity_led_teacher")
@ApiModel(value="LedTeacher对象", description="研学带队老师")
public class LedTeacher implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "研学带队老师主键")
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

    @ApiModelProperty(value = "老师姓名")
    private String name;

    @ApiModelProperty(value = "老师类型，1：带队老师2：随队老师")
    @TableField("teacherType")
    private Integer teacherType;

    @ApiModelProperty(value = "状态; 0无效, 1有效")
    private Integer status;

    @ApiModelProperty(value = "创建人user_id")
    private String creator;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改人user_id")
    private String updator;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "手机号")
    @TableField("phoneNumber")
    private Integer phoneNumber;

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
