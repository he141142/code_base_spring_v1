package com.sykros.codebase.utils.module.validator;

import com.sykros.codebase.enums.Entity;
import com.sykros.codebase.repositories.BookRepository;
import com.sykros.codebase.repositories.InventoryRepository;
import com.sykros.codebase.repositories.RoleRepository;
import com.sykros.codebase.service.interfaces.IBookService;
import com.sykros.codebase.service.interfaces.IUserService;
import com.sykros.codebase.utils.module.validator.entity.*;
import org.springframework.beans.factory.annotation.Autowired;


public class EntityValidator {
    IBookService bookService;
    EntityValidate entityValidate;
    private Entity entity;

    @Autowired
    IUserService userService;

    public EntityValidator PlugEntity(Entity entity) {
        this.entity = entity;
        switch (this.entity) {
            case BOOK -> {
                this.entityValidate = new BookEntityValidation().
                        injectBookService(bookService);
            }
            case ACCOUNT -> {
                this.entityValidate = new AccountEntityValidation().injectUserService(userService);
            }
            case INVENTORY -> {
                this.entityValidate = new AccountEntityValidation();
            }
            case ROLE -> {
                this.entityValidate = new AccountEntityValidation();
            }
        }
        return this;
    }

    public EntityValidator(Builder builder) {
        this.bookService = builder.bookService;
    }

    public EntityValidator InjectRepository(RoleRepository roleRepository, InventoryRepository inventoryRepository) {
        return this;
    }

    public boolean IsEntityExistById(Long id) {
        return this.entityValidate.IsEntityExistById(id);
    }

    public static class Builder {
        IBookService bookService;

        Builder InjectBookService(IBookService bookService) {
            this.bookService = bookService;
            return this;
        }

        public EntityValidator build() {
            return new EntityValidator(this);
        }
    }


}
