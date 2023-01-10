package com.sykros.codebase.service;

import com.sykros.codebase.domain.Role;
import com.sykros.codebase.enums.RoleEnum;
import com.sykros.codebase.repositories.RoleRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RoleInitializer implements CommandLineRunner {

    @Setter
    @Autowired
    private RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            List<Role> roles = roleRepository.findAll();
            if (roles.isEmpty()){
                roles = loadRoles();
                roleRepository.saveAll(roles);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }
    }

    private List<Role> loadRoles() {
        return Arrays.asList(
                new Role(RoleEnum.USER),
                new Role(RoleEnum.ADMIN),
                new Role(RoleEnum.GUEST)
        );
    }
}