package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.Role;
import com.example.ngoProjects.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    //  finding by unsername or email

    Optional<User> findByusernameOrEmail(String username, String email);
    User findByUsername(String username);
    boolean existsByEmail(String email);

    User findByConformationToken(String token);
    List<User> findAllByRoles(Set<Role> roles);
}
