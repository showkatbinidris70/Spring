package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.ReceivingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiveingDetailsRepo extends JpaRepository<ReceivingDetails, Long>{
    ReceivingDetails findByReceiverName (String receiverName);
}
