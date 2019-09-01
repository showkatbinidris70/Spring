package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepo extends JpaRepository<Parcel, Long> {

    Parcel findByParcelName (String parcelName);
}
