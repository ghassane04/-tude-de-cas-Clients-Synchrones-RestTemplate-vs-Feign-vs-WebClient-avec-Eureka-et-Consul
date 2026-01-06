package com.ghbou.swarch.clientservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-voiture")
public interface VehicleFeignClient {

    @GetMapping("/api/cars/byClient/{clientId}")
    Car getCarByClient(@PathVariable("clientId") Long clientId);
}
