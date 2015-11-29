package ua.park.gorky.core.validator.annotation;

import ua.park.gorky.core.validator.StringNotEmptyValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Vladyslav_Yemelianov
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = StringNotEmptyValidator.class)
public @interface StringNotEmpty {
}

