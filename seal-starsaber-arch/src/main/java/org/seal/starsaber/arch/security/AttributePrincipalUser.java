package org.seal.starsaber.arch.security;

import lombok.Data;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Data
public class AttributePrincipalUser implements PrincipalUser {
    private String name;
}
