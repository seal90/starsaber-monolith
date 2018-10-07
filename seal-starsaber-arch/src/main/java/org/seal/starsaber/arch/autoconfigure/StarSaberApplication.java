package org.seal.starsaber.arch.autoconfigure;

import org.seal.starsaber.arch.conf.cache.EnableCacheConfig;
import org.seal.starsaber.arch.conf.database.DataBaseConfig;
import org.seal.starsaber.arch.conf.date.DateFormatterConfig;
import org.seal.starsaber.arch.conf.exception.UnifiedExceptionConfig;
import org.seal.starsaber.arch.conf.json.ObjectMapperConfig;
import org.seal.starsaber.arch.conf.log.ControllerLogConfig;
import org.seal.starsaber.arch.conf.log.ServiceExceptionLogConfig;
import org.seal.starsaber.arch.conf.security.SecurityConfig;
import org.seal.starsaber.arch.conf.swagger.SealSwaggerConfig;
import org.seal.starsaber.arch.conf.webmvc.WebMvcConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.annotation.*;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 *
 * @EnableCaching EnableCacheConfig
 * @EnableWebSecurity SecurityConfig
 * @EnableGlobalMethodSecurity(prePostEnabled = true)  SecurityConfig
 * @EnableTransactionManagement DataBaseConfig
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAsync
@Import({SealSwaggerConfig.class, UnifiedExceptionConfig.class, DateFormatterConfig.class, EnableCacheConfig.class,
        SecurityConfig.class, DataBaseConfig.class, WebMvcConfig.class, ControllerLogConfig.class,
        ServiceExceptionLogConfig.class, ObjectMapperConfig.class})
public @interface StarSaberApplication {
}
