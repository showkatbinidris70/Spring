package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepositRepo extends JpaRepository<Deposit, Long> {

    //  finding by depositBranch

   // Optional<Deposit> findByDepositBranch(String depositBranch);

    Deposit findByDepositBranch(String depositBranch);

    boolean existsByDepositBranch(String depositBranch);
}
