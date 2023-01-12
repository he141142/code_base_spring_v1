package com.sykros.codebase.decorators;

import com.sykros.codebase.enums.Entity;
import com.sykros.codebase.utils.module.validator.EntityValidator;
import com.sykros.codebase.utils.module.validator.ValidatorComponent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsEntityExistValidator implements ConstraintValidator<IsEntityExist, Long> {

    IsEntityExist annotationMeta;

    @Autowired
    public void setEntityValidator(EntityValidator entityValidator) {
        this.entityValidator = entityValidator;
    }
    EntityValidator entityValidator;

    @Override
    public void initialize(IsEntityExist constraintAnnotation) {
        this.annotationMeta = constraintAnnotation;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long entityId, ConstraintValidatorContext constraintValidatorContext) {
        return entityId == null || this.
                entityValidator.
                PlugEntity(this.annotationMeta.ForEntity()).
                IsEntityExistById(entityId);
    }


}
