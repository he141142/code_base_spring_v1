package com.sykros.codebase.decorators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsEntityExistValidator.class)
public @interface IsEntityExist {


    //error message
    public String message() default "Invalid color: must be RED, GREEN or BLUE";

    //represents group of constraints
    public Class<?>[] groups() default {};

    public Class<?> ForClass();

    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
