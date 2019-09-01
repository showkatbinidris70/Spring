package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.Airways;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirwaysRepo extends JpaRepository<Airways, Long> {


    Airways findByAirwaysName(String airwaysName);


}
