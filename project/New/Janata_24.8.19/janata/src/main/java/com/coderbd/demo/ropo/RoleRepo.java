package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    //finding by roleNome
    Role findByRoleName(String roleName);

    boolean existsRoleByRoleName(String roleName);
}

