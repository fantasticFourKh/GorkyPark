package ua.park.gorky.core.validator;

import ua.park.gorky.core.validator.annotation.StringLength;
import ua.park.gorky.core.validator.api.IValidator;

import java.lang.annotation.Annotation;

/**
 * @author Vladyslav_Yemelianov
 */
public class StringLengthValidator implements IValidator {
    @Override
    public String validate(Annotation ann, Object obj) {
        StringLength stringLength = (StringLength) ann;
        int maxLength = stringLength.length();
        String value = obj.toString();
        if (value.length() > maxLength) {
            return stringLength.message();
        }
        return null;
    }
}
