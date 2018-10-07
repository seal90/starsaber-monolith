package org.seal.starsaber.arch.argumentresolver;

import org.seal.starsaber.arch.security.PrincipalUser;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Order(1)
public class PrincipalUserArgumentResolver implements HandlerMethodArgumentResolver {

  private PrincipalUserResolver resolver;
  
  public boolean supportsParameter(MethodParameter parameter) {
    return PrincipalUser.class.isAssignableFrom(parameter.getParameterType());
  }
  
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    return resolver.resolve(parameter, mavContainer, webRequest, binderFactory);
  }
  
  public void setPrincipalUserResolver(PrincipalUserResolver resolver) {
    this.resolver = resolver;
  }

}