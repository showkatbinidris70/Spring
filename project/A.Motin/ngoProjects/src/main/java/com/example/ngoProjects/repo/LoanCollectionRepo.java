package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.LoanCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanCollectionRepo extends JpaRepository<LoanCollection, Long> {
}
