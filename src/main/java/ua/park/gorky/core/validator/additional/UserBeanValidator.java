package ua.park.gorky.core.validator.additional;

import ua.park.gorky.core.util.DateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Vladyslav
 */
public interface UserBeanValidator {
    default void validateDob(Map<String, List<String>> errors, String dob) {
        if (!DateUtil.isCorrectDate(dob)) {
            errors.put("dob", Arrays.asList("Incorrect date format"));
        }
    }

    default void comparePasswords(Map<String, List<String>> errors, String password, String repeatPassword) {
        if (!password.equals(repeatPassword)) {
            errors.put("password", Arrays.asList("Password are not same"));
        }
    }
}
