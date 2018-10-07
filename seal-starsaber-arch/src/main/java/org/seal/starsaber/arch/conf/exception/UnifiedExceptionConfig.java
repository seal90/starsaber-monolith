package org.seal.starsaber.arch.conf.exception;

import org.seal.starsaber.arch.exception.ServiceException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@ControllerAdvice
@ResponseBody
@ConditionalOnProperty(name = "seal.arch.unified.exception.handle.enable", matchIfMissing = true)
public class UnifiedExceptionConfig {


    @ExceptionHandler(value= ServiceException.class)
    public ResponseEntity<Map<String, Object>> serviceErrorException(HttpServletRequest request,
                                                                     ServiceException serviceException){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", 491);
        body.put("error", "Service Error");
        body.put("exception", ServiceException.class.getName());
        body.put("errors", serviceException.getData());
        body.put("message", serviceException.getMessage());
        body.put("path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_ACCEPTABLE);
    }


}
