this project is a small mvp for something that i didn't know how to do, aggregate messages of spring cloud stream 
in a timeframe.

this is proccessor app of spring cloud stream witch mean i receives messages and produces and output from those
messages, so to use run the docker compose(if you don't have already an instance of akka up)

$docker-compose up

run this app

generate json messages to the topic 

setAggregatorProcessor-in-0

and you will see the output in the topic

setAggregatorProcessor-out-0


the only thing that this app does is accumulate the messages that receives every 20 seconds into a singe message
of the list of all the messages.
based on https://github.com/spring-cloud/spring-cloud-stream-samples/blob/main/processor-samples/sensor-average-reactive-kafka/src/main/java/sample/sensor/average/SensorAverageProcessorApplication.java

