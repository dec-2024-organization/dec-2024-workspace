package com.demo.swiggy_driver.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.demo.swiggy_driver.constant.AppConstant;

@Configuration
public class KafkaConfig {
	@Bean
	public NewTopic topic() {
		return TopicBuilder.name(AppConstant.TOPIC_DRIVER_LOCATION).build();
	}
}
