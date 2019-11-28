package com.hosyfy.erp.web.rest;

import com.hosyfy.erp.service.ErpKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/erp-kafka")
public class ErpKafkaResource {

    private final Logger log = LoggerFactory.getLogger(ErpKafkaResource.class);

    private ErpKafkaProducer kafkaProducer;

    public ErpKafkaResource(ErpKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
