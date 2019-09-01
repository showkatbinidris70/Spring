package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByCustomerName(String customerName);

    Iterable<Customer> findAllByDistrict(String district);

}
