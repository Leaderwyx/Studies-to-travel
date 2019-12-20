package com.ketai.activity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 研学活动评分
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "EvaluateGroup对象", description = "研学活动评分")
public class EvaluateGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "研学活动评分")
    private String score;

    @ApiModelProperty(value = "评分数量")
    private Integer cnt;


}
