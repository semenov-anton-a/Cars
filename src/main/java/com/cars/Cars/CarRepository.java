package com.cars.Cars;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Query(value = "INSERT INTO CAR_CLIENTS VALUES( :carID, :clientID )", nativeQuery = true)
    @Modifying
    public void addLinks( @Param("clientID") Long clientID, @Param("carID") Long carID );


}
