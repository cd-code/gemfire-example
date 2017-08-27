package me.cauley.gemfireserverdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleEvent {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleEvent.class);
	
	@Scheduled(initialDelay=5000, fixedRate=3000)
	public void exec() {
		LOGGER.info("I am schduled!!!!");
	}
}
