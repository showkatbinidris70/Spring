package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.CollectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionTypeRepo extends JpaRepository<CollectionType, Long> {
}
