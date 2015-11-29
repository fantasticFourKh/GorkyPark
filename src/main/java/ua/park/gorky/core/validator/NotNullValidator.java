package ua.park.gorky.core.validator;


import ua.park.gorky.core.validator.api.IValidator;

import java.lang.annotation.Annotation;

/**
 * Created by Vladyslav_Yemelianov on 5/7/2015.
 */
public class NotNullValidator implements IValidator {
    @Override
    public String validate(Annotation ann, Object obj) {
        if (obj == null){
            return "Object is null";
        }
        return null;
    }
}
