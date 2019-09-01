package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {


    //  finding by  accountHolderName or  accountCodeNumber

    Optional<Account> findByAccountHolderNameOrAccountCodeNumber(String  accountHolderName, String  accountCodeNumber);

    Account findByAccountHolderName(String  accountHolderName);

    boolean existsByAccountCodeNumber(String  accountCodeNumber);
}
