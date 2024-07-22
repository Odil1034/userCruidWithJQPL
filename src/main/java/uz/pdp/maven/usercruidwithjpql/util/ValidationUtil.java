package uz.pdp.maven.usercruidwithjpql.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;
import java.util.StringJoiner;

public class ValidationUtil {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    public ValidationUtil() {
        this.validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = validatorFactory.getValidator();
    }

    public boolean isValid(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object, Object.class);
        if (violations.isEmpty()) {
            return true;
        } else {
            StringJoiner message = new StringJoiner("\n");
            for (ConstraintViolation<Object> violation : violations) {
                message.add(violation.getInvalidValue() + " " +
                        violation.getPropertyPath() + "  " +
                        violation.getMessage());
            }
            System.out.println(message);
            return false;
        }
    }
}
