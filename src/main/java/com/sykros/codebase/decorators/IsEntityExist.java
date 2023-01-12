package com.sykros.codebase.decorators;

import com.sykros.codebase.enums.Entity;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsEntityExistValidator.class)
public @interface IsEntityExist {
    //error message
    public String message() default "Entity Doesn't exist";

    //represents group of constraints
    public Class<?>[] groups() default {};


    public Entity ForEntity();

    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
