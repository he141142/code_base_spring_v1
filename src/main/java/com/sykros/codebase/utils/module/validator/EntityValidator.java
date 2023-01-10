package com.sykros.codebase.utils.module.validator;

import com.sykros.codebase.enums.Entity;
import com.sykros.codebase.repositories.BookRepository;
import com.sykros.codebase.repositories.InventoryRepository;
import com.sykros.codebase.repositories.RoleRepository;
import com.sykros.codebase.service.interfaces.IBookService;
import com.sykros.codebase.utils.module.validator.entity.*;


public class EntityValidator{
    IBookService bookService;
    EntityValidate entityValidate;

    private RoleRepository roleRepository;
    private InventoryRepository inventoryRepository;


    AccountValidate accountValidate;
    BookEntityValidate bookEntityValidate;

    private Entity entity;

    public EntityValidator PlugEntity(Entity entity){
        this.entity = entity;
        switch (this.entity){
            case BOOK -> {
                this.bookEntityValidate = new BookEntityValidation().
                        injectRepository(bookRepository);
            }
            case ACCOUNT -> {
                this.accountValidate = new AccountEntityValidation();
            }
        }
        return this;
    }

    public EntityValidator(Builder builder){
        this.bookService = builder.bookService;
    }

    public EntityValidator InjectRepository(RoleRepository roleRepository,InventoryRepository inventoryRepository){
        this.roleRepository = roleRepository;
        this.inventoryRepository = inventoryRepository;
        return this;
    }

    public static class Builder{
        IBookService bookService;
        Builder InjectBookService(IBookService bookService){
            this.bookService = bookService;
            return this;
        }

        public EntityValidator build(){
            return new EntityValidator(this);
        }
    }


}
