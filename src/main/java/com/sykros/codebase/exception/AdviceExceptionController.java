package com.sykros.codebase.exception;

import com.sykros.codebase.exception.violations.ViolationConstraint;
import com.sykros.codebase.exception.violations.ViolationEntity;
import com.sykros.codebase.utils.responseUtils.ResponseMessage;
import com.sykros.codebase.utils.responseUtils.SykrosResponseEntity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AdviceExceptionController {

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    public ResponseEntity<?> onMethodArgumentInvalid(ConstraintViolationException e) {
        ViolationConstraint validationConstraint = new ViolationConstraint();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            validationConstraint.addViolation(
                    new ViolationEntity(violation.getPropertyPath().toString(), violation.getMessage())
            );
        }
        return SykrosResponseEntity.
                buildResponseEntity(new ResponseMessage.
                        Builder<>().
                        setData(validationConstraint).
                        withMessage("error on validate parameter").
                        status(HttpStatus.BAD_REQUEST).
                        build());
    }

}
