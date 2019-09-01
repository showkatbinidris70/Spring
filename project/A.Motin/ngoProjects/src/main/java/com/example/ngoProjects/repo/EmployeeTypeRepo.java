package com.example.ngoProjects.repo;

import com.example.ngoProjects.entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeTypeRepo extends JpaRepository<EmployeeType, Long> {

    //finding by empType
//Optional<EmployeeType> findByTypeName(String typeName);


    EmployeeType findByTypeName(String typeName);
    boolean existsEmployeeTypeByTypeName(String typeName);


}
