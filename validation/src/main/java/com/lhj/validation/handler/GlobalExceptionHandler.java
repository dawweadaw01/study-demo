package com.lhj.validation.handler;
import com.lhj.validation.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Objects;

/**
 * @author banyanmei
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 参数校验异常
     * @param exception MethodArgumentNotValidException
     * @return 400
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseUtils methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        log.error("[MethodArgumentNotValidException]: {}", exception.getMessage());
        return ResponseUtils.of(exception.getBody().getStatus(),
                Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage(), null);
    }
}
