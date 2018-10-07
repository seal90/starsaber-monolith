package org.seal.starsaber.arch.argumentresolver;

import org.seal.starsaber.arch.security.AttributePrincipalUser;
import org.seal.starsaber.arch.util.RequestUtil;
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
public class DefaultAttributePrincipalUserResolver implements PrincipalUserResolver {

    @Override
    public Object resolve(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                          WebDataBinderFactory binderFactory) throws Exception {
        AttributePrincipalUser user = new AttributePrincipalUser();
        user.setName(RequestUtil.principalName().orElse(""));
        return user;
    }
}
