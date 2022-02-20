package com.project.co.SetAggregator

import org.springframework.context.annotation.Configuration
import org.springframework.integration.aggregator.ReleaseStrategy
import org.springframework.integration.store.MessageGroup
import org.springframework.scheduling.annotation.Scheduled

@Configuration
class ReleaseConfiguration:ReleaseStrategy {

    var release:Boolean=false

    @Scheduled(fixedDelay = 20000)
    private fun releaseFlag(){
        release=true;
    }

    override fun canRelease(group: MessageGroup?): Boolean {
        return if(release){
            release=false
            true;
        }else{
            false;
        }
    }
}