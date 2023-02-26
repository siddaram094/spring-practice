package com.spring.student.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumeMessage {

	@KafkaListener(topics = "sample-test",groupId = "group1")
	public void consume(String message) {
		System.out.println("consumed message : "+message);
		
	}
}
