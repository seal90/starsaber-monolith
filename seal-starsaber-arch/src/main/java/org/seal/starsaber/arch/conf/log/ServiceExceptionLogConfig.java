package org.seal.starsaber.arch.conf.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.seal.starsaber.arch.exception.ServiceException;
import org.seal.starsaber.arch.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Aspect
@Slf4j
@Configuration
@ConditionalOnProperty(name = "seal.arch.log.service.exception.enable", matchIfMissing = true)
public class ServiceExceptionLogConfig {

    @Autowired
    @Qualifier("filterTypeObjectMapper")
    private ObjectMapper objectMapper;

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void log(){}

    /**
     * 记录异常信息
     * @param jp
     * @param ex
     */
    @AfterThrowing(pointcut="log()", throwing="ex")
    public void log(JoinPoint jp, Exception ex){
        if(!ServiceException.class.isAssignableFrom(ex.getClass())) {
            MethodSignature signature = (MethodSignature) jp.getSignature();
            //获取被拦截的方法
            Method method = signature.getMethod();
            //获取被拦截的类名
            String className = method.getDeclaringClass().getName();
            //获取被拦截的方法名
            String methodName = method.getName();
            Object[] args = jp.getArgs();
            String argsStr = "Convert args error";
            try {
                argsStr = objectMapper.writeValueAsString(args);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            log.error("ServiceExceptionLog principalName: {} className: {} methodName: {} args: {} exception: {}",
                    RequestUtil.principalName().orElse("no user login"), className, methodName, argsStr,
                    ex.getMessage());
        }
    }
}
