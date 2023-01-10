package com.sykros.codebase.decorators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsEntityExistValidator implements ConstraintValidator<IsEntityExist,Long> {

    IsEntityExist annotationMeta;

    @Override
    public void initialize(IsEntityExist constraintAnnotation) {
        this.annotationMeta = constraintAnnotation;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long entityId, ConstraintValidatorContext constraintValidatorContext) {
        this.annotationMeta.message();
        constraintValidatorContext.
        return false;
    }


}
