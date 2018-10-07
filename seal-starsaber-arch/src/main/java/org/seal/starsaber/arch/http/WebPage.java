package org.seal.starsaber.arch.http;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Data
public class WebPage<T> {

    @NotNull
    private Integer pageNum;

    @NotNull
    private Integer pageSize;

    private Long total;

    private T data;

    private Map<String,String> orderBy;
}
