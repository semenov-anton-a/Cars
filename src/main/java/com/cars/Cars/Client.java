package com.cars.Cars;

import javax.persistence.Entity;
// import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends AbstractPersistable<Long> {

    // VIN Code
    private String firstname;

    // Reg number
    private String surname;
    
    // @ManyToMany
    // private List<Tili> tilit = new ArrayList<>();

}
