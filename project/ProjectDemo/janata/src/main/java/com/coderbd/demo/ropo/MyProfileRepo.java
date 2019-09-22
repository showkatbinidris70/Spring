package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.MyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyProfileRepo extends JpaRepository<MyProfile, Long> {

    Optional<MyProfile> findByUsernameOrEmail(String username, String email);

    MyProfile findByUsername(String username);

    boolean existsByEmail(String email);

}
