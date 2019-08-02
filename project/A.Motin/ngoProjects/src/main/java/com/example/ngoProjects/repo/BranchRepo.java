package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {


    //  finding by branchName or branchCode

    Optional<Branch> findByBranchNameOrBranchCode(String branchName, String branchCode);

    Branch findByBranchName(String branchName);

    boolean existsByBranchCode(String branchCode);

}
