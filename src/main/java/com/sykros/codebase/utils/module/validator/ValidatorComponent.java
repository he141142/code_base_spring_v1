package com.sykros.codebase.utils.module.validator;

import com.sykros.codebase.enums.Entity;
import com.sykros.codebase.repositories.BookRepository;
import com.sykros.codebase.repositories.InventoryRepository;
import com.sykros.codebase.repositories.RoleRepository;
import com.sykros.codebase.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ValidatorComponent {
    @Autowired
    private IBookService bookService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private InventoryRepository inventoryRepository;


    @Bean()
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    EntityValidator EntityValidator() {
        return new EntityValidator.Builder().
                InjectBookService(this.bookService).
                build().
                InjectRepository(
                        roleRepository,
                        inventoryRepository);
    }

}
