package org.seal.starsaber.arch.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
public class RequestUtil {

    public static HttpServletRequest notNullRequest(){
        Optional<HttpServletRequest> request = request();
        return request.get();
    }

    public static Optional<HttpServletRequest> request(){
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if(null != attributes){
            HttpServletRequest request = ((ServletRequestAttributes)attributes).getRequest();
            return Optional.ofNullable(request);
        }
        return Optional.empty();
    }

    public static Optional<Principal> principal(){
        Optional<HttpServletRequest> request =  request();
        if(request.isPresent()){
            Principal principal = request.get().getUserPrincipal();
            return Optional.ofNullable(principal);
        }
        return Optional.empty();
    }

    public static Optional<String> principalName(){
        Optional<Principal> principal = principal();
        if(principal.isPresent()){
            String name = principal.get().getName();
            return Optional.ofNullable(name);
        }
        return Optional.empty();
    }

}
