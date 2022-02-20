package com.project.co.SetAggregator

import org.springframework.context.annotation.Configuration
import org.springframework.integration.aggregator.MessageGroupProcessor
import org.springframework.integration.store.MessageGroup
import org.springframework.messaging.Message

@Configuration
class AbstractAggregatingMessageGroupProcessor: MessageGroupProcessor {
    override fun processMessageGroup(group: MessageGroup?): List<Message<*>> {
        val messages: List<Message<*>> =group?.messages?.toList()?: emptyList()
        return messages;
    }
}