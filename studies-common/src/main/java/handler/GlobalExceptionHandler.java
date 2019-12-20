package handler;

import constants.ResultCodeEnum;
import exception.KetaiException;
import util.ExceptionUtil;
import entity.Result;
import com.fasterxml.jackson.core.JsonParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理器
 *
 * @author Childe Liao
 * @since 2019/12/1
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().message(e.getMessage());
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public Result error(BadSqlGrammarException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Result error(JsonParseException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    @ExceptionHandler(KetaiException.class)
    @ResponseBody
    public Result error(KetaiException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().message(e.getMessage()).code(e.getCode());
    }


}
