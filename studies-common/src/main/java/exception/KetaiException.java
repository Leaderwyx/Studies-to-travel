package exception;

import constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Childe Liao
 * @since 2019/12/1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "全局异常")
public class KetaiException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    /**
     * 接受状态码和消息
     *
     * @param code    状态码
     * @param message 错误信息
     */
    public KetaiException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型
     *
     * @param resultCodeEnum {@link ResultCodeEnum}
     */
    public KetaiException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

}
