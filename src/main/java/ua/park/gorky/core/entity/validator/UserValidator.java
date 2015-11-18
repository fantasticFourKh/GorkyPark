package ua.park.gorky.core.entity.validator;

import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.entity.exception.ValidateException;

/**
 * Created by ��������� on 17 ��� 2015 �..
 */
public class UserValidator {

    public static void validateUser(User user) {

        if (user.getFirstName().isEmpty() || user.getLastName().isEmpty() ||
                user.getLogin().isEmpty() || user.getEmail().isEmpty() || user.getPhone().isEmpty() || user.getPassword().isEmpty()) {
            throw new ValidateException("Empty fields");
        }

        if (!validatePhone(user.getPhone())) {
            throw new ValidateException("Incorrect phone format");
        }

        if (!validateNameSurname(user.getFirstName())) {
            throw new ValidateException("Incorrect name format");
        }

        if (!validateNameSurname(user.getLastName())) {
            throw new ValidateException("Incorrect lasname format");
        }

        if (!validateEmail(user.getEmail())) {
            throw new ValidateException("Incorrect email format");
        }

        if (!validateLoginPassword(user.getLogin())) {
            throw new ValidateException("Incorrect login format");
        }

        if (!validateLoginPassword(user.getPassword())) {
            throw new ValidateException("Incorrect password format");
        }
    }

    private static boolean validateNameSurname(String ns) {
        if (Character.isUpperCase(ns.charAt(0))) {
            return true;
        }
        return false;
    }

    private static boolean validateEmail(String email) {
        if (email.matches("^\\w.+@\\w+[.][a-z]+$")) {
            return true;
        }
        return false;
    }

    public static boolean validateLoginPassword(String password) {
        if (password.matches("^[a-zA-Z0-9_-]{3,16}$")) {
            return true;
        }
        return false;
    }

    private static boolean validatePhone(String phone) {
        if (phone
                .matches("^(\\+38)?[0](50|63|66|67|68|91|92|93|94|95|96|97|98|99)\\d{7}$")) {
            return true;
        }
        return false;
    }

}
