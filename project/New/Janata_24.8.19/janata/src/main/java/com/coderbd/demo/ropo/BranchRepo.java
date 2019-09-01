package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.Branch;
import com.coderbd.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {

    Optional<Branch> findByBranchNameOrEmail(String username, String email);

    Branch findByBranchName(String username);

    boolean existsByEmail(String email);

//    Iterable<Parcel> findAllByProductType(String productType);
//    Iterable<Parcel> findAllByProductTypeAndSendCountry(String productType, String sendCountry);
//    Iterable<Parcel> findAllByProductTypeAndReceivedTo(String productType, String receivedTo);

    Iterable<Branch> findAllByBranchName(String branchName);



}
