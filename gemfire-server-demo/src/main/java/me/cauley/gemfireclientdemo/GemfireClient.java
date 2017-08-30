package me.cauley.gemfireclientdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.listener.ContinuousQueryDefinition;
import org.springframework.data.gemfire.listener.ContinuousQueryListenerContainer;
import org.springframework.data.gemfire.listener.adapter.ContinuousQueryListenerAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.google.common.collect.Sets;

@SpringBootApplication
@EnableScheduling
public class GemfireClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GemfireClient.class);
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(GemfireClient.class);
		ctx.registerShutdownHook();
		
//		ClientCache cache = new ClientCacheFactory().addPoolLocator("localhost", 10334).create();
//		Region<Long, Long> factorialsRegion = cache.<Long, Long>createClientRegionFactory(ClientRegionShortcut.PROXY).create("Factorials");
//		LOGGER.info("Result: " + factorialsRegion.get(12L));
	}
	
	@Bean
	public ContinuousQueryListenerContainer createContainer(ContinuousQueryDefinition definition) {
		ClientCache cache = new ClientCacheFactory().setPoolSubscriptionEnabled(true).addPoolLocator("localhost", 10334).create();
//		Region<Long, Long> factorialsRegion = cache.<Long, Long>createClientRegionFactory(ClientRegionShortcut.PROXY).create("Factorials");
//		LOGGER.info("Result: " + factorialsRegion.get(12L));
		
		ContinuousQueryListenerContainer container = new ContinuousQueryListenerContainer();
		container.setCache(cache);
		container.setQueryListeners(Sets.newHashSet(definition));
		
		return container;
	}
	
	@Bean
	public ContinuousQueryDefinition createdDefinition(EventDelegate delegate) {
		ContinuousQueryDefinition definition = new ContinuousQueryDefinition("select * from /Factorials", new ContinuousQueryListenerAdapter(delegate));
		
		return definition;
	}
	
	@Scheduled(fixedDelay=10000)
	public void keepRunning() {
		
	}
	
}
