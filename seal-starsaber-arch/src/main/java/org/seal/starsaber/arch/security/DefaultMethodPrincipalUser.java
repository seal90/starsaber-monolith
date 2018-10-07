package org.seal.starsaber.arch.security;

import org.seal.starsaber.arch.util.RequestUtil;

import java.util.Optional;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
public class DefaultMethodPrincipalUser implements MethodPrincipalUser {

    @Override
    public String getName() {
        Optional<String> name = RequestUtil.principalName();
        if(name.isPresent()){
            return name.get();
        }
        return null;
    }
}
