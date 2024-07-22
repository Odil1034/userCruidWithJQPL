package uz.pdp.maven.usercruidwithjpql.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;
import java.util.StringJoiner;

public interface ValidationUtil {

    static String isValid(Object object) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (violations.isEmpty()) {
            return "true";
        } else {
            StringJoiner message = new StringJoiner("\n");
            for (ConstraintViolation<Object> violation : violations) {
                message.add(violation.getInvalidValue() + " " +
                        violation.getPropertyPath() + "  " +
                        violation.getMessage());
            }
            return message.toString();
        }
    }
}
