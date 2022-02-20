package com.project.co.SetAggregator

import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.context.annotation.Bean
import org.springframework.integration.aggregator.CorrelationStrategy
import org.springframework.scheduling.annotation.Scheduled


@EnableBinding(Processor::class)
class SetAggregatorProcessor(val storageService: StorageService) {
    @Input
    public fun inputMessage(input: Map<String,Any>){
        storageService.messages.add(input)
    }

    @Output
    @Scheduled(fixedDelay = 20000)
    public fun produceOutput():List<Map<String,Any>>{
        val message= storageService.messages
        storageService.messages.clear()
        return message;
    }



}