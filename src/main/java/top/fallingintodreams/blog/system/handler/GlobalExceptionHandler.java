package top.fallingintodreams.blog.system.handler;

import cn.dev33.satoken.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.fallingintodreams.blog.system.common.ApiResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotLoginException.class)
    public ApiResponse notLoginException(NotLoginException e) {
        return ApiResponse.error("请登录后再试");
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse unknownException(Exception e) {
        log.error("未知异常", e);
        return ApiResponse.error("服务器错误，请稍后再试");
    }

}
