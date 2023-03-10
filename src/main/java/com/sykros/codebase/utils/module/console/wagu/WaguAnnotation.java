package com.sykros.codebase.utils.module.console.wagu;


import com.sykros.codebase.decorators.IsEntityExistValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WaguAnnotation {
    public String Header();
}
