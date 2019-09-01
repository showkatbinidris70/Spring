package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTypeRepo extends JpaRepository<LoanType, Long> {

    //finding by typeName
    LoanType findByTypeName(String typeName);
    boolean existsLoanTypeByTypeName(String typeName);
}
