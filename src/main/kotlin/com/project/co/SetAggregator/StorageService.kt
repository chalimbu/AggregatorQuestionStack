package com.project.co.SetAggregator

import org.springframework.stereotype.Service

@Service
class StorageService {
    public var messages: MutableList<Map<String,Any>> = mutableListOf()
}