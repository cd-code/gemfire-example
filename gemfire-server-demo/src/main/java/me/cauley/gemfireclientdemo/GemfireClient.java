package me.cauley.gemfireclientdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;

@SpringBootApplication
public class GemfireClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GemfireClient.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(GemfireClient.class);
		ClientCache cache = new ClientCacheFactory().addPoolLocator("localhost", 10334).create();
		Region<Long, Long> factorialsRegion = cache.<Long, Long>createClientRegionFactory(ClientRegionShortcut.PROXY).create("Factorials");
		LOGGER.info("Result: " + factorialsRegion.get(12L));
	}
	
}
