package me.cauley.gemfireserverdemo.function;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.gemfire.function.annotation.GemfireFunction;
import org.springframework.data.gemfire.function.config.EnableGemfireFunctions;
import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.internal.cache.execute.RegionFunctionContextImpl;
import com.google.common.collect.Lists;

@Component
@EnableGemfireFunctions
public class GemfireFunctionImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(GemfireFunctionImpl.class);
	
	@GemfireFunction
	public List<Long> extractFunction(String v1, String v2, FunctionContext context) {
		LOGGER.info("function executed");
		Region<Long, Long> region = ((RegionFunctionContextImpl)context).getDataSet();
		LOGGER.info("value: " + region.values());
		return Lists.newArrayList(region.values());
	}
}
