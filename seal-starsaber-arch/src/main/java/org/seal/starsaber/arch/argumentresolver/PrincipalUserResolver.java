package org.seal.starsaber.arch.argumentresolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
public interface PrincipalUserResolver {

    Object resolve(MethodParameter parameter, ModelAndViewContainer mavContainer,
                   NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception;
}
