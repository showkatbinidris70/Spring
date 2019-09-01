package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.Packing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingRepo extends JpaRepository<Packing, Long> {
    Packing findByPackingCode (String packingCode);
}
