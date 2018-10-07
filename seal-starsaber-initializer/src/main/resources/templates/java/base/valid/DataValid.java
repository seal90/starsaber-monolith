package {{packageName}}.base.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DataValidValidator.class)
public @interface DataValid {

    String message() default "{org.seal.starsaber.arch.valid.DataValid.message}";

    DataValidKind kind() default DataValidKind.ALL;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
