package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.DistributionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionDetailsRepo extends JpaRepository<DistributionDetails, Long> {
    DistributionDetails findByParcelName (String parcelName);


}
