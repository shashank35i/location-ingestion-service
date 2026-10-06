package com.goon.locationingestion.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor

public class LocationProducer {

    private static final Logger log = (Logger) LoggerFactory.getLogger(LocationProducer.class);

    private final KafkaTemplate<String,Object> kafkaTemplate;
    private final AppProperties appProperties;


    public void produceRideLocation(LocationEvent locationEvent){
        send(appProperties.ingestionLocationUpdates(), locationEvent.rideId(), locationEvent);
    }

    public void produceDriverLocation(LocationEvent locationEvent){
        send(appProperties.ingestionDriverLocations(), locationEvent.driverId(), locationEvent);
    }
    public void send(String topic,String key,LocationEvent locationEvent){
        kafkaTemplate.send(topic,key,locationEvent).whenComplete((result,ex)->{
                    if(ex!=null){
                        log.error("");
                    }
                 }
               );
    }


}
