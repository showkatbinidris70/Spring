package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.Account;
import com.example.ngoProjects.entity.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawRepo extends JpaRepository<Withdraw, Long> {
    //finding by account
    Withdraw findByAccount(Account account);
    boolean existsWithdrawByAccount(Account account);
}
