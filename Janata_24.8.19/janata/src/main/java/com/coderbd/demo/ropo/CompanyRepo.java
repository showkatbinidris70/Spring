package com.coderbd.demo.ropo;


        import com.coderbd.demo.entity.Company;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.Optional;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
    //  finding by unsername or email

    Optional<Company> findByCompanyNameOrEmail(String companyName, String email);

    Company findByCompanyName(String companyName);

    boolean existsByEmail(String email);

}
