package org.seal.startsaber.sealstarsaberdemo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * Table: consumer
 */
@Data
public class Consumer implements Serializable {
    /**
     * 主键
     *
     */
    private String id;

    /**
     * 年龄
     *
     */
    private Integer age;

    /**
     * 姓名
     *
     */
    private String name;

    /**
     * 出生日期
     *
     */
    private Date birthday;

    /**
     * 创建日期
     *
     */
    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;
}