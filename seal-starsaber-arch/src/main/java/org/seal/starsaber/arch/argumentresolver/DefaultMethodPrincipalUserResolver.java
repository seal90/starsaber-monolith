package org.seal.starsaber.arch.argumentresolver;


import lombok.Data;
import org.seal.starsaber.arch.security.PrincipalUser;
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
@Data
public class DefaultMethodPrincipalUserResolver implements PrincipalUserResolver {

    private PrincipalUser principalUser;

    @Override
    public Object resolve(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                          WebDataBinderFactory binderFactory) throws Exception {

        return principalUser;
    }
}
