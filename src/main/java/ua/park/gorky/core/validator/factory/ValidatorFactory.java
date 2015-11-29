package ua.park.gorky.core.validator.factory;

import org.springframework.stereotype.Component;
import ua.park.gorky.core.exception.ClassInitializationException;
import ua.park.gorky.core.exception.NoAttributeAccessException;
import ua.park.gorky.core.validator.annotation.Constraint;
import ua.park.gorky.core.validator.api.IValidator;

import java.lang.annotation.Annotation;

/**
 *
 * @author Vladyslav_Yemelianov
 **/
@Component
public class ValidatorFactory {

	public IValidator getValidatorBy(Annotation annotation) {
		try {
			for (Annotation ann : annotation.annotationType().getAnnotations()) {
				if (ann instanceof Constraint) {
					Constraint conAnnotation = (Constraint) ann;
					return conAnnotation.validatedBy().newInstance();
				}
			}
		} catch (IllegalAccessException e) {
			throw new NoAttributeAccessException("Field is not accessible.");
		} catch (InstantiationException e) {
			throw new ClassInitializationException(
					"Class initialization failed.");
		}
		throw new IllegalArgumentException();
	}

}
