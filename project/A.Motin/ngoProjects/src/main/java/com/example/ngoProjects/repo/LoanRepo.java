package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {

    //  finding by loanCodeNumber


    Loan findByLoanCodeNumber(String loanCodeNumber);

    boolean existsByLoanCodeNumber(String loanCodeNumber);
}
