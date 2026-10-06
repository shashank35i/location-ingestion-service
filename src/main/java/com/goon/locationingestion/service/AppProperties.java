package com.goon.locationingestion.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kafka.topics")
public record AppProperties(
        String ingestionLocationUpdates,
        String ingestionDriverLocations
) {
}
