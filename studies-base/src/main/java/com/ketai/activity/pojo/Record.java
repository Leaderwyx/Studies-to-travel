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
 * 研学风采
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("activity_record")
@ApiModel(value="Record对象", description="研学风采")
public class Record implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "研学风采主键")
      @TableId(value = "id", type = IdType.NONE)
    private String id;

    @ApiModelProperty(value = "活动ID")
    private String activityId;

    @ApiModelProperty(value = "record活动风采 recordHome 首页8张风采 默认为record")
    private String type;

    @ApiModelProperty(value = "所属peopletype")
    private String ownerPeopleType;

    @ApiModelProperty(value = "所属people id")
    private String ownerPeopleId;

    @ApiModelProperty(value = "记录人peopleType")
    private String recordPeopleType;

    @ApiModelProperty(value = "记录人peopleId")
    private String recordPeopleId;

    @ApiModelProperty(value = "身份名称")
    private String recordPeopleName;

    @ApiModelProperty(value = "学生风采学年学期")
    private String schyearTerm;

    @ApiModelProperty(value = "评价内容")
    private String content;

    @ApiModelProperty(value = "公开类型: 0仅自己可见， 1公开")
    private Integer publicStatus;

    @ApiModelProperty(value = "状态: 0已删除, 1正常")
    private Integer status;

    @ApiModelProperty(value = "创建人user_id")
    private String creator;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改人user_id")
    private String updator;

    @ApiModelProperty(value = "更新时间")
      @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "图片地址")
    @TableField("imageUrl")
    private String imageUrl;


}
