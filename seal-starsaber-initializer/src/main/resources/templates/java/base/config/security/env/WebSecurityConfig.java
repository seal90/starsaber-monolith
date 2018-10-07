package {{packageName}}.base.config.security.env;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.seal.starsaber.arch.http.ResponseOkEntity;
import org.seal.startsaber.sealstarsaberdemo.base.config.security.WebPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Profile("default")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 可修改
     * 可以更新访问目录拦截规则
     * 若实现按照请求 URL 进行权限过滤，则在这里配置 Filter
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
            .and().formLogin().successHandler((HttpServletRequest request, HttpServletResponse response,
                                                   Authentication authentication)->{
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(ResponseOkEntity.create("login success")));
        }).failureHandler((HttpServletRequest request, HttpServletResponse response,
                           AuthenticationException exception)->{
            // 可以判断异常类型来区分登录异常详细信息
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(ResponseOkEntity.create("login error")));
        }).and().anonymous().disable();
    }

    /**
     * 必须修改
     * 实现此获取用户信息的接口
     * 即 UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
     * 可以参考默认实现
     *  JdbcUserDetailsManager
     *  CachingUserDetailsService
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        return (String userName)->{

            return null;
        };
    }


    /**
     * 可以修改
     * spring 推荐加密方式
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 可以修改
     * 若使用下面注解限制权限则需要修改 WebPermissionEvaluator 中规则
     * @PreAuthorize("hasPermission(null,'has_per')")
     * hasPermission(null,'has_per') 解析
     * @return
     */
    @Bean
    public PermissionEvaluator permissionEvaluator(){
        return new WebPermissionEvaluator();
    }
}
