package com.sykros.codebase.service.interfaces;

import com.sykros.codebase.domain.Role;
import com.sykros.codebase.exception.entity.EntityException;

public interface IRoleService {
    Role GetRoleById(Long id) throws EntityException;
}
