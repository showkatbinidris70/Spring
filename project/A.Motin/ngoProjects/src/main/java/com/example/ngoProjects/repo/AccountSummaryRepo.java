package com.example.ngoProjects.repo;


import com.example.ngoProjects.entity.Account;
import com.example.ngoProjects.entity.AccountSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSummaryRepo extends JpaRepository<AccountSummary, Long> {

    //finding by account
    AccountSummary findByAccount(Account account);
    boolean existsAccountSummaryByAccount(Account account);

}
