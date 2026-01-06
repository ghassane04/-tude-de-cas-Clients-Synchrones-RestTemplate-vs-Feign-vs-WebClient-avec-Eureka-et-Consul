package com.ghbou.swarch.carservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Long id;
    private String marque;
    private String modele;
    private Long clientId;

    // Factory method for cleaner instantiation if needed
    public static Car of(Long id, String marque, String modele, Long clientId) {
        return new Car(id, marque, modele, clientId);
    }
}
