package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.ShippingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingDetailsRepo extends JpaRepository<ShippingDetails, Long> {

    ShippingDetails findByRecieverName(String recieverName);
}
