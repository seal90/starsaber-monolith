package org.seal.startsaber.sealstarsaberdemo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Data
public class ValidationDemoEntity {

    @NotEmpty
    private String name;

    @Range(max = 150, min = 0, message = "年龄在 0 - 150 之间")
    private Integer age;

    @Length(min = 6, max = 10)
    @Pattern(regexp = "[a-zA-Z]*", message = "密码不合法")
    private String password;
}
