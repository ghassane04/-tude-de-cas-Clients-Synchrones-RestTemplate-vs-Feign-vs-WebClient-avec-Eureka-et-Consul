package com.ghbou.swarch.clientservice;

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
}
