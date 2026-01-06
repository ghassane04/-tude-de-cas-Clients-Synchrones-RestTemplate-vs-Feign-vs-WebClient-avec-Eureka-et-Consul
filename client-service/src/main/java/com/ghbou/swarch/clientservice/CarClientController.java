package com.ghbou.swarch.clientservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class CarClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private VehicleFeignClient vehicleFeignClient;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private static final String CAR_SERVICE_URL = "http://service-voiture/api/cars/byClient/";

    @GetMapping("/api/clients/{id}/car/rest")
    public Car fetchCarViaRestTemplate(@PathVariable Long id) {
        return restTemplate.getForObject(CAR_SERVICE_URL + id, Car.class);
    }

    @GetMapping("/api/clients/{id}/car/feign")
    public Car fetchCarViaFeign(@PathVariable Long id) {
        return vehicleFeignClient.getCarByClient(id);
    }

    @GetMapping("/api/clients/{id}/car/webclient")
    public Car fetchCarViaWebClient(@PathVariable Long id) {
        return webClientBuilder.build()
                .get()
                .uri(CAR_SERVICE_URL + id)
                .retrieve()
                .bodyToMono(Car.class)
                .block(); // Blocking for synchronous comparison in this lab
    }
}
