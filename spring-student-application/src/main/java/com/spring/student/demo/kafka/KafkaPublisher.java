package com.spring.student.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("kafka")
public class KafkaPublisher {

	/* The below kafka template object is needed when  we don't need the serilization of value , 
	 * means when we want to send the string data to kafka topic.
	 * 
	 * 
	 * */
	@Autowired
	KafkaTemplate<String, EmployeeDetails> kafkaTemplae;
	private static final String TOPIC = "sample-test";
	
	@ApiOperation(tags = "kafka",value="test kafka publisher")
	@PostMapping("publish")
	public String postMessage(@RequestBody EmployeeDetails employeeDetails) {
		
		kafkaTemplae.send(TOPIC, employeeDetails);
		return "message Published";
	}
}
