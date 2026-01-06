package com.ghbou.swarch.carservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private static final Logger log = LoggerFactory.getLogger(CarController.class);

    @GetMapping("/api/cars/byClient/{clientId}")
    public Car findCarByClientId(@PathVariable Long clientId) {
        log.info("Fetching car details for client ID: {}", clientId);
        
        simulateDatabaseLatency();

        // Returning diverse data for demonstration
        return Car.of(10L, "Renault", "Clio", clientId);
    }

    private void simulateDatabaseLatency() {
        try {
            // Slight variation in latency for realism
            Thread.sleep(50); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Latency simulation interrupted", e);
        }
    }
}
