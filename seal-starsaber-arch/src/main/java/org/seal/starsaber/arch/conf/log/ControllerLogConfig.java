package org.seal.starsaber.arch.conf.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.seal.starsaber.arch.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Aspect
@Slf4j
@Configuration
@ConditionalOnProperty(name = "seal.arch.log.controller.enable", matchIfMissing = true)
public class ControllerLogConfig {

    private static final String CONTROLLERLOGCONFIG_PRE_TIME = "CONTROLLERLOGCONFIG_PRE_TIME";

    @Value("${seal.arch.log.controller.logSplitMark: }")
    private String logSplitMark;

    @Value("${seal.arch.log.controller.requestParameter:}")
    private String[] requestParameter;

    @Autowired
    @Qualifier("filterTypeObjectMapper")
    private ObjectMapper objectMapper;

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) " +
            "|| @within(org.springframework.stereotype.Controller)")
    private void log(){}

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        HttpServletRequest request = RequestUtil.notNullRequest();
        request.setAttribute(CONTROLLERLOGCONFIG_PRE_TIME, System.currentTimeMillis());
    }

    @AfterReturning(pointcut = "log()", returning = "returnValue")
    public void logAfterReturning(JoinPoint joinPoint, Object returnValue){
        String returnValueString = "Convert Message error";

        try {
            returnValueString = objectMapper.writeValueAsString(returnValue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String val = logRequest("AfterReturning", joinPoint,"Return Value is ", returnValueString);
        log.info(val);
    }

    @AfterThrowing(pointcut = "log()", throwing = "throwable")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable throwable){
         String val = logRequest("AfterThrowing", joinPoint,
                "Exception is ", throwable.getClass().getName(), "Message is ", throwable.getMessage());
        log.error(val);
    }

//    @After(value = "log()")
//    public void logAfter(JoinPoint joinPoint){
//        Object[] objects = joinPoint.getArgs();
//        HttpServletRequest request = RequestUtil.notNullRequest();
//        long time = (long)request.getAttribute(CONTROLLERLOGCONFIG_PRE_TIME);
//        long timeConsuming = System.currentTimeMillis()-time;
//        try {
//            String value = objectMapper.writeValueAsString(objects);
//            log.info("\n After Request Info:\n URI is {}\n Method is {}\n Args is {}\n Time-consuming is {} ms",
//                    request.getRequestURI(), request.getMethod(), value, timeConsuming);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }

    private String logRequest(String ponitName, JoinPoint joinPoint, String ... keyValues){
        Object[] args = joinPoint.getArgs();
        String argsVal = "Convert args error";
        try {
            argsVal = objectMapper.writeValueAsString(args);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpServletRequest request = RequestUtil.notNullRequest();
        long time = (long)request.getAttribute(CONTROLLERLOGCONFIG_PRE_TIME);
        long timeConsuming = System.currentTimeMillis()-time;

        StringBuilder builder = new StringBuilder();
        builder.append(ponitName).append(" Request Info:")
                .append("principalName is ").append(RequestUtil.principalName().orElse("no user login")).append(logSplitMark)
                .append("URI is ").append(request.getRequestURI()).append(logSplitMark)
                .append("Method is ").append(request.getMethod()).append(logSplitMark)
                .append("Time-consuming is ").append(timeConsuming).append(logSplitMark)
                .append("Args is").append(argsVal).append(logSplitMark);
        if(requestParameter.length >0) {
            builder.append("Parameter is ").append("{ ");
            for(String parameter : requestParameter){
                builder.append(parameter).append(":").append(request.getParameter(parameter)).append(", ");
            }
            builder.deleteCharAt(builder.length()-2);
//            Enumeration<String> parameterEnum = request.getParameterNames();
//            while (parameterEnum.hasMoreElements()) {
//                String name = parameterEnum.nextElement();
//                builder.append(name).append(":").append(request.getParameter(name)).append(", ");
//            }
            builder.append("}").append(logSplitMark);
        }

        if(null != keyValues) {
            for (int i = 0; i < keyValues.length; i++) {
                builder.append(keyValues[i]).append(keyValues[++i]).append(logSplitMark);
            }
        }
        return builder.toString();
    }

}
