package org.seal.startsaber.sealstarsaberdemo.base.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
public class DataValidValidator implements ConstraintValidator<DataValid, Object> {

    private DataValid dataValid;

    @Override
    public void initialize(DataValid dataValid) {
        this.dataValid = dataValid;
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if(null != object){
            return true;
        }
        return false;
    }
}
