package ua.park.gorky.core.validator;


import org.springframework.stereotype.Component;
import ua.park.gorky.core.bean.ViewBean;
import ua.park.gorky.core.exception.NoAttributeAccessException;
import ua.park.gorky.core.validator.annotation.NotNull;
import ua.park.gorky.core.validator.api.IBeanValidator;
import ua.park.gorky.core.validator.factory.ValidatorFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

@Component
public class BeanValidator implements IBeanValidator {
    private ValidatorFactory factory = new ValidatorFactory();

    @Override
    public Map<String, List<String>> validateBean(ViewBean bean) {
        Map<String, List<String>> exceptions = new HashMap<>();
        try {
            for (Field field : bean.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                for (Annotation ann : field.getAnnotations()) {
                    String message = factory.getValidatorBy(ann).validate(ann,
                            field.get(bean));
                    if (ann instanceof NotNull) {
                        if (message != null) {
                            break;
                        }
                    }
                    addMistake(exceptions, field.getName(), message);
                }
            }
        } catch (IllegalAccessException e) {
            throw new NoAttributeAccessException(
                    "Field is not accessible outside.");
        }
        return exceptions;
    }

    private void addMistake(Map<String, List<String>> exceptions, String key,
                            String message) {
        if (message == null) {
            return;
        }
        try {
            exceptions.get(key).add(message);
        } catch (NullPointerException e) {
            exceptions.put(key, new ArrayList<>(Arrays.asList(message)));
        }
    }

}
