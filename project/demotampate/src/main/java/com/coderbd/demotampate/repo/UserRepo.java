package com.coderbd.demotampate.repo;

import com.coderbd.demotampate.entity.Role;
import com.coderbd.demotampate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUserNameOrEmail(String userName, String email);

    User findByUserName(String username);

    /////////////////
    User findByUserNameOrName(String username, String name);

    User findByUserNameAndName(String username, String name);

    List<User> findAllByRoles(Set<Role> roles);
}
