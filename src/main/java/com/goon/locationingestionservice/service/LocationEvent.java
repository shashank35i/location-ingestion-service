package com.goon.locationingestionservice.service;

public record LocationEvent(
        String driverId,
        String rideId,
        double lat,
        double lon,
        long timestamp) {
}
