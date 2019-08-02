package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.Ngo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgoRepo extends JpaRepository<Ngo, Long> {

    Ngo findByName(String name);

}
