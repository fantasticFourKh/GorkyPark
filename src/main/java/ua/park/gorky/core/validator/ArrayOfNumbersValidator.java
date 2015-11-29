package ua.park.gorky.core.validator;


import ua.park.gorky.core.validator.api.IValidator;

import java.lang.annotation.Annotation;

/**
 * @author Vladyslav
 */
public class ArrayOfNumbersValidator implements IValidator {
    @Override
    public String validate(Annotation ann, Object obj) {
        String[] arr = (String[]) obj;
        for (String el : arr) {
            try {
                Integer.parseInt(el);
            } catch (NumberFormatException e){
                return "Not numeric value found.";
            }
        }
        return null;
    }
}
