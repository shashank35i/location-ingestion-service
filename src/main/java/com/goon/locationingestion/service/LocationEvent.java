package com.goon.locationingestion.service;

public record LocationEvent(
        String driverId,
        String rideId,
        double lat,
        double lon,
        long timestamp) {
}
