package org.ironforge.err;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.bo.IronforgeResp;
import org.ironforge.constants.IronforgeCode;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
    public IronforgeResp handleException(Exception e) {
        log.error("打印错误", e);
        if (e instanceof NoHandlerFoundException) {
            return IronforgeResp.status(IronforgeCode.INVALID_PATH);
        }

        if (e instanceof HttpRequestMethodNotSupportedException) {
            return IronforgeResp.status(IronforgeCode.INVALID_METHOD);
        }

        if (e instanceof HttpMediaTypeNotSupportedException) {
            return IronforgeResp.status(IronforgeCode.INVALID_MEDIA_TYPE);
        }

        if (e instanceof IllegalArgumentException) {
            return new IronforgeResp(IronforgeCode.INVALID_ARGUMENT.getCode(), e.getMessage());
        }

        if (e instanceof IronforgeException) {
            IronforgeException exception = (IronforgeException) e;
            return IronforgeResp.status(exception.retrieve());
        }

        return IronforgeResp.status(IronforgeCode.UNKNOWN);
    }
}
