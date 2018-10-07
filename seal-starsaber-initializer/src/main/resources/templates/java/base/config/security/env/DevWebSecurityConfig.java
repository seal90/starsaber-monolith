package {{packageName}}.base.config.security.env;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.seal.starsaber.arch.http.ResponseOkEntity;
import org.seal.startsaber.sealstarsaberdemo.base.config.security.WebPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Profile("dev")
@Configuration
public class DevWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ObjectMapper objectMapper;
    /**
     * 打开 Cors，允许所有跨域
     * 所有请求路径都校验，不包括springboot 默认放开的路径
     * 登录方式 form 和 basic
     *  form 登录时，正确与错误处理
     * 关闭 csrf
     * 关闭 anonymous
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource((request) -> (buildConfig()))
            .and().authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
            .anyRequest().authenticated()
            .and().formLogin().successHandler((HttpServletRequest request, HttpServletResponse response,
                                               Authentication authentication)->{
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(objectMapper.writeValueAsString(ResponseOkEntity.create("login success")));
        }).failureHandler((HttpServletRequest request, HttpServletResponse response,
                           AuthenticationException exception)->{
            // 可以判断异常类型来区分登录异常详细信息
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(ResponseOkEntity.create("login error")));
        }).and().httpBasic()
            .and().csrf().disable().anonymous().disable();
    }

    /**
     * 配置默认登陆用户名及密码 u/p 用户
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("u").password("p").roles("USER");
    }

    /**
     * 密码加密规则，spring boot 2.0 没有默认配置
     * 这里使用的是已经过期的明文比对，建议生产不要使用
     * @return
     */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    /**
     * @PreAuthorize("hasPermission(null,'has_per')")
     * hasPermission(null,'has_per') 解析
     * @return
     */
    @Bean
    public PermissionEvaluator permissionEvaluator(){
        return new WebPermissionEvaluator();
    }

    /**
     * 配置跨域访问
     * @return
     */
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        // 1 设置访问源地址
        corsConfiguration.addAllowedOrigin("*");
        // 2 设置访问源请求头
        corsConfiguration.addAllowedHeader("*");
        // 3 设置访问源请求方法
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }
}
