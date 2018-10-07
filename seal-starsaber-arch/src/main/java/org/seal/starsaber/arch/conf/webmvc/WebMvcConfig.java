package org.seal.starsaber.arch.conf.webmvc;

import org.seal.starsaber.arch.argumentresolver.DefaultAttributePrincipalUserResolver;
import org.seal.starsaber.arch.argumentresolver.DefaultMethodPrincipalUserResolver;
import org.seal.starsaber.arch.argumentresolver.PrincipalUserArgumentResolver;
import org.seal.starsaber.arch.argumentresolver.PrincipalUserResolver;
import org.seal.starsaber.arch.security.DefaultMethodPrincipalUser;
import org.seal.starsaber.arch.security.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Configuration
@Order
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private PrincipalUser principalUser;

    @Autowired
    private PrincipalUserResolver principalUserResolver;

    @Bean
    @ConditionalOnMissingBean({PrincipalUser.class})
    public PrincipalUser principalUser(){
        DefaultMethodPrincipalUser user = new DefaultMethodPrincipalUser();
        return user;
    }

//    @Bean
//    public PrincipalUserResolver attributePrincipalUserResolver(){
//        DefaultAttributePrincipalUserResolver resolver=  new DefaultAttributePrincipalUserResolver();
//        return resolver;
//    }

    @Bean
    @ConditionalOnMissingBean({PrincipalUserResolver.class})
    public PrincipalUserResolver methodPrincipalUserResolver(){
        DefaultMethodPrincipalUserResolver resolver=  new DefaultMethodPrincipalUserResolver();
        resolver.setPrincipalUser(principalUser);
        return resolver;
    }



    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PrincipalUserArgumentResolver principalUserArgumentResolver = new PrincipalUserArgumentResolver();
        principalUserArgumentResolver.setPrincipalUserResolver(principalUserResolver);
        argumentResolvers.add(principalUserArgumentResolver);
    }
}
