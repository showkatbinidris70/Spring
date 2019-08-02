package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.DepositType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositTypeRepo extends JpaRepository<DepositType, Long> {
}
