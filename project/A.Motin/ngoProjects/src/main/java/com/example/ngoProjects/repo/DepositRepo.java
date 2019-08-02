package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepo extends JpaRepository<Deposit, Long> {
}
