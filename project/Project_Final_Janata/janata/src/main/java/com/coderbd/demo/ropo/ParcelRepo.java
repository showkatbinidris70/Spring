package com.coderbd.demo.ropo;

import com.coderbd.demo.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ParcelRepo extends JpaRepository<Parcel, Long> {

    Parcel findByParcelName (String parcelName);


    Iterable<Parcel> findAllByProductType(String productType);
    Iterable<Parcel> findAllByDeliveryType(String deliveryType);

    Iterable<Parcel>findAllByReceivedToAndProductType(String productType,String receivedTo);

//    Iterable<Parcel> findAllByProductTypeAndSendCountry(String productType, String sendCountry);
//    Iterable<Parcel> findAllByProductTypeAndReceivedTo(String productType, String receivedTo);
//    Iterable<Parcel> findAllByDeliveryDate(Date deliveryDate);

}
