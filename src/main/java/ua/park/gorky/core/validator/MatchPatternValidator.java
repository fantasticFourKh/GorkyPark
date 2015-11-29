package ua.park.gorky.core.validator;

import ua.park.gorky.core.validator.annotation.MatchPattern;
import ua.park.gorky.core.validator.api.IValidator;

import java.lang.annotation.Annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vladyslav_Yemelianov
 **/
public class MatchPatternValidator implements IValidator {

	@Override
	public String validate(Annotation ann, Object obj) {
		MatchPattern annPattern = (MatchPattern) ann;
		Pattern pattern = Pattern.compile(annPattern.pattern());
		if (!validate(obj, pattern)) {
			return annPattern.message();
		}
		return null;
	}

	private boolean validate(Object field, Pattern pattern) {
		Matcher matcher = pattern.matcher(String.valueOf(field));
		return matcher.matches();
	}

}
