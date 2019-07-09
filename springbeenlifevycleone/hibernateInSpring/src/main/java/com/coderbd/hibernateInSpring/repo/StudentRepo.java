package com.coderbd.hibernateInSpring.repo;

import com.coderbd.hibernateInSpring.entity.Department;
import com.coderbd.hibernateInSpring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Iterable<Student>findAllByDepartment(Department department);
}