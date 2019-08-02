package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.Branch;
import com.coderbd.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {
    Optional<Branch> findBranchNameOrEmail(String branchName, String email);
    Branch findByBranchName (String branchName);

    boolean existsByEmail(String email);

}
