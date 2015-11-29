package ua.park.gorky.core.validator.api;

import java.lang.annotation.Annotation;

/**
 *
 * @author Vladyslav_Yemelianov
 **/
public interface IValidator {
	String validate(Annotation ann, Object obj);
}

