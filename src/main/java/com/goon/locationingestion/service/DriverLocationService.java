package com.goon.locationingestion.service;

import com.goon.locationingestion.service.request.LocationPingRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter
public class DriverLocationService {

 private LocationProducer locationProducer;

    public void produce( String driverId, LocationPingRequest locationPingRequest){
        LocationEvent event = new LocationEvent(
                driverId,
                locationPingRequest.rideId(),
                locationPingRequest.lat(),
                locationPingRequest.lon(),
                locationPingRequest.timestamp());
            if(event.rideId()!=null && !event.rideId().isBlank()){
                locationProducer.produceRideLocation(event);
            }
            else{
                locationProducer.produceDriverLocation(event);
            }
    }
}
