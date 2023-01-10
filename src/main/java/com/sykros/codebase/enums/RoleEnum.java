package com.sykros.codebase.enums;

import lombok.Getter;
import lombok.Setter;

public enum RoleEnum {
    USER(new RoleEnum.RoleEntity("USER","Base role for authentication, basic service")),
    ADMIN(new RoleEnum.RoleEntity("ADMIN","admin control the system")),
    GUEST(new RoleEnum.RoleEntity("GUEST","..."));

    RoleEntity roleEntity;

    RoleEnum(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public String Name(){
        return this.roleEntity.getName();
    }

    public String Description(){
        return this.roleEntity.getDescription();
    }

    @Getter
    public static final class RoleEntity{
        String name;
        String description;

        public RoleEntity( String name,String description){
            this.description = description;
            this.name = name;
        }
    }

}
