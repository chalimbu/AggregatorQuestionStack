package com.project.co.SetAggregator

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.aggregator.CorrelationStrategy
import org.springframework.messaging.Message

@Configuration
class CorrelactionStrategy:CorrelationStrategy {
    override fun getCorrelationKey(message: Message<*>?): Any {
        return "all";
    }
}