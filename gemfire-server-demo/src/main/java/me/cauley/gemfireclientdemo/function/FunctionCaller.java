package me.cauley.gemfireclientdemo.function;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FunctionCaller {
	private static final Logger LOGGER = LoggerFactory.getLogger(FunctionCaller.class);
	
	@Autowired
	private FunctionExecution functionExecution;
	
	@Scheduled(fixedRate=5000)
	public void callFunction() {
		Collection<Long> result = functionExecution.extract("v1", "v2");
		LOGGER.info("Result: " + result);
	}
}
