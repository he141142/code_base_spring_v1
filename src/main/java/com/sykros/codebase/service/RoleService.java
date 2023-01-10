package com.sykros.codebase.service;

import com.sykros.codebase.domain.Role;
import com.sykros.codebase.enums.Exception.entity.EntityExceptionEnum;
import com.sykros.codebase.exception.entity.EntityException;
import com.sykros.codebase.exception.entity.RoleException;
import com.sykros.codebase.repositories.RoleRepository;
import com.sykros.codebase.service.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role GetRoleById(Long id) throws EntityException {
        Optional<Role> role = this.roleRepository.findById(id);
        this.CheckRoleEmpty(role);
        return role.orElse(null);
    }

    public Role FindRoleByName(String name) throws EntityException {
        Optional<Role> role = this.roleRepository.findOneByName(name);
        this.CheckRoleEmpty(role);
        return role.orElse(null);
    }


    private void CheckRoleEmpty( Optional<Role> role) throws EntityException {
        if (role.isEmpty()) {
            throw new RoleException.
                    builder().
                    WithException(EntityExceptionEnum.ROLE_NOT_FOUND_EXCEPTION).build();
        }
    }

}
