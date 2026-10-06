package com.goon.locationingestion.config;



import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {
    private final String locationUpdates;
    private final String driverLocations;

    public KafkaConfig(@Value("${app.kafka.topics.ingestion-location-updates}") String locationUpdates,
                       @Value("${app.kafka.topics.ingestion-driver-locations}") String driverLocations)
    {

        this.locationUpdates = locationUpdates;
        this.driverLocations = driverLocations;
    }

    @Bean
    public NewTopic locationUpdates(){
        return TopicBuilder
                .name(locationUpdates)
                .build();
    }

    @Bean
    public NewTopic driverLocations(){
        return TopicBuilder
                .name(driverLocations)
                .build();
    }

}
