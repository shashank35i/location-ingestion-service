package com.goon.locationingestionservice.controller;

import com.goon.locationingestionservice.service.DriverLocationService;
import com.goon.locationingestionservice.service.request.LocationPingRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/ingestion")
@RequiredArgsConstructor
public class DriverLocationController {

    private final DriverLocationService driverLocationService;

    @PostMapping
    public ResponseEntity<Void> ingestLocation(
            @Valid @RequestBody LocationPingRequest request,
            @RequestHeader("X-User-Id") String driverId
    ) {
        driverLocationService.produce(driverId, request);
        return ResponseEntity.accepted().build();
    }
}


