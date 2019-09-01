package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByusernameOrEmail(String username, String email);
    User findByUsername(String username);
    boolean existsByEmail(String email);

    User findByConformationToken(String token);

  //  List<User> findAllByRoles(Set<Role> roles);
}
