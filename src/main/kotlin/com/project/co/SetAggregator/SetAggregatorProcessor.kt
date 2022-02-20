package com.project.co.SetAggregator


import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import reactor.core.publisher.GroupedFlux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*
import java.util.function.BiFunction
import java.util.function.Function

@Configuration
class SetAggregatorProcessor : Function<Flux<Map<String, Any>>, Flux<MutableList<Map<String, Any>>>> {

    override fun apply(data: Flux<Map<String, Any>>):Flux<MutableList<Map<String, Any>>> {
        return data.window(Duration.ofSeconds(20)).flatMap { window: Flux<Map<String, Any>> ->
           this.aggregateList(window)

        }
    }

    private fun aggregateList(group: Flux<Map<String, Any>>): Mono<MutableList<Map<String, Any>>>? {
        return group.reduce(
            mutableListOf(),
            BiFunction<MutableList<Map<String, Any>>, Map<String, Any>, MutableList<Map<String, Any>>> {
                    acumulator: MutableList<Map<String, Any>>, element: Map<String, Any> ->
                acumulator.add(element)
                acumulator
            }
        )
    }
}