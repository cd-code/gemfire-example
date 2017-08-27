package me.cauley.gemfireserverdemo;

import java.math.BigInteger;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.PartitionedRegionFactoryBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.Region;

@Component
public class ScheduleEvent {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleEvent.class);
	
	@Autowired
	PartitionedRegionFactoryBean<Long, Long> factorialsRegion;

	@Autowired
	PartitionedRegionFactoryBean<BigInteger, BigInteger> sumRegion;
	
	private Random random = new Random();;
	
	@Scheduled(initialDelay=1000, fixedRate=1000)
	public void execFactorials() throws Exception {
		LOGGER.info("Enter execFactorials with factoryBean: " + factorialsRegion);
		Region<Long, Long> factorials = factorialsRegion.getObject();
		LOGGER.info(factorials + " region was schduled!!!!");
		
		long key = random.nextInt(30);
		LOGGER.info("FactorialsRegion key: " + key + ", value: " + factorials.get(key));
	}
	
	@Scheduled(initialDelay=2000, fixedRate=1000)
	public void execSum() throws Exception {
		LOGGER.info("Enter execSum with factoryBean: " + sumRegion);
		Region<BigInteger, BigInteger> sum = sumRegion.getObject();
		LOGGER.info(sum + " region was schduled!!!!");
		
		BigInteger key = new BigInteger(random.nextLong() + "");
		if(BigInteger.ZERO.compareTo(key) > 0) {
			LOGGER.info("key is negative: " + key.toString());
			key = key.multiply(new BigInteger("-1"));
		}
		LOGGER.info("SumRegion key: " + key.toString() + ", value: " + sum.get(key));
	}
}
