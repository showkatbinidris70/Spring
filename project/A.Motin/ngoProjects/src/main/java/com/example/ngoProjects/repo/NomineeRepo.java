package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeRepo extends JpaRepository<Nominee, Long> {

    //finding by roleNome
    Nominee findByNomineeName(String nomineeName);
    boolean existsRoleByNomineeName(String nomineeName);
}
