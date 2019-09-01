package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.SendingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendingDetailsRepo extends JpaRepository<SendingDetails, Long> {
    SendingDetails findBySenderName (String senderName);
}
