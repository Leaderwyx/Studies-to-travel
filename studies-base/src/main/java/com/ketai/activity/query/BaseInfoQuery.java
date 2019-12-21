package com.ketai.activity.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "BaseInfo查询对象", description = "研学基地查询对象封装")
@Data
public class BaseInfoQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "研学基地名称，模糊查询")
    private String baseName;
}
