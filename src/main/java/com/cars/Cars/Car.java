package com.cars.Cars;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

// import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends AbstractPersistable<Long> {

    // VIN Code
    private String vinCode;

    // Reg number
    private String carReg;
    
    // Car Brand
    private String carBrand;

    // Car Model
    private String carModel;

    // Car Year
    private String carYear;

    @ManyToMany
    private List<Client> clients = new ArrayList<>();

}
