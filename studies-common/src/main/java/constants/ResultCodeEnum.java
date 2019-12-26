package constants;

import lombok.Getter;

/**
 * 返回码定义枚举类
 *
 * @author Childe Liao
 * @since 2019/12/1
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(true, 20000, "成功"),
    UNKNOWN_REASON(false, 20001, "未知错误"),
    BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
    JSON_PARSE_ERROR(false, 21002, "json解析异常"),
    PARAM_ERROR(false, 21003, "参数不正确"),
    FILE_UPLOAD_ERROR(false, 21004, "文件上传错误"),
    EXCEL_DATA_EXPORT_ERROR(false, 21005, "Excel数据导出错误"),
    USERLOGIN_INVALID_ERROR(false, 21006,"登录信息过期，请重新登录"),
    ENTITY_COULD_NOT_BE_FOUND(false, 21007,"找不到对应实体"),
    USERUNLOGIN_ERROR(false, 21008,"用户未登录，请重新登录");

    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

}
