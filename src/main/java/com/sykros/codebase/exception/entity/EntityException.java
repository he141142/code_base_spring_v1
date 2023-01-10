package com.sykros.codebase.exception.entity;

import com.sykros.codebase.enums.Exception.entity.EntityExceptionEnum;

public class EntityException extends Exception{
    boolean throwable = false;
    EntityExceptionEnum entityExceptionEnum;

    public EntityException(EntityExceptionEnum entityExceptionEnum){
        this.entityExceptionEnum = entityExceptionEnum;
    }

    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class builder<S extends builder>{
        String exceptionMessage;

        public builder WithException(EntityExceptionEnum entityExceptionEnum){
            this.exceptionMessage = entityExceptionEnum.getExceptionMessage();
            return this;
        }

        public EntityException build(){
            return new EntityException(this.exceptionMessage);
        }
    }

}
