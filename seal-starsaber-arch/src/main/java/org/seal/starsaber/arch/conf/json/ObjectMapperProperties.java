package org.seal.starsaber.arch.conf.json;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.List;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Data
@ConfigurationProperties(prefix = "seal.arch.json.objectmapper")
public class ObjectMapperProperties {

    private List<String> ignoreClass = Collections.emptyList();

}
