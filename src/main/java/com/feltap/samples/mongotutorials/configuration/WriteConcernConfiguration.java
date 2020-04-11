package com.feltap.samples.mongotutorials.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.WriteConcernResolver;
import org.springframework.stereotype.Component;

import com.mongodb.WriteConcern;

@Component
public class WriteConcernConfiguration {

	@Bean
	public WriteConcernResolver writeConcernResolver() {
		
		return action -> {
			if (action.getEntityType().getSimpleName().contains("Person")) {
				return WriteConcern.ACKNOWLEDGED;
			} else if (action.getEntityType().getSimpleName().contains("Metric")) {
				return WriteConcern.UNACKNOWLEDGED;
			}
			return WriteConcern.ACKNOWLEDGED;
		};
	}

}
