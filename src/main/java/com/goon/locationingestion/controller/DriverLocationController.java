package com.goon.locationingestion.controller;

import com.goon.locationingestion.service.DriverLocationService;
import com.goon.locationingestion.service.request.LocationPingRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ingestion")
@RequiredArgsConstructor
public class DriverLocationController {

    private final DriverLocationService driverLocationService;

    @PostMapping
    public ResponseEntity<String> ingestLocation(@Valid @RequestBody LocationPingRequest locationPingRequest,
                                         @RequestHeader("Driver-Id") String driverId) throws InterruptedException {
        for(int i=0;i<20;i++) {
            LocationPingRequest l = new LocationPingRequest(
                    Math.random(),
                    Math.random(),
                    System.currentTimeMillis(),
                    null

            );


            driverLocationService.produce(driverId, l);
            Thread.sleep(1000);
        }

                ResponseEntity.accepted().build();
        return new ResponseEntity<>("done", HttpStatus.OK);

    };

}
