package org.seal.starsaber.arch.conf.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Data
@ConfigurationProperties(prefix = "seal.arch.swagger")
public class SealSwaggerProperties {

    private Boolean enable = false;

    /**
     * 扫描基础路径
     */
    private String basePackage = "org.seal.starsaber.arch";

    /**
     * 标题
     */
    private String title = "标题";

    /**
     * 项目版本号
     */
    private String version = "0.0.1";

    /**
     * 项目描述
     */
    private String description = "项目描述";

    /**
     * 创建人信息
     */
    private Contact contact = new Contact();

    @Data
    class Contact {
        /**
         * 创建人名
         */
        private String name = "Seal";

        /**
         * 创建人主页
         */
        private String url = "seal.org";

        /**
         * 创建人邮箱
         */
        private String email = "seal@seal.org";
    }
}
