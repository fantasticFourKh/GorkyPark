package ua.park.gorky.core.validator;

import ua.park.gorky.core.validator.annotation.MatchPattern;
import ua.park.gorky.core.validator.api.IValidator;

import java.lang.annotation.Annotation;

/**
 *
 * @author Vladyslav_Yemelianov
 **/
public class MatchPatternValidator implements IValidator {

	@Override
	public String validate(Annotation ann, Object obj) {
		MatchPattern annPattern = (MatchPattern) ann;
		if (!String.valueOf(obj).matches(annPattern.pattern())) {
			return annPattern.message();
		}
		return null;
	}

}
