package me.cauley.gemfireclientdemo.function;

import java.util.Collection;
import java.util.List;

import org.springframework.data.gemfire.function.annotation.FunctionId;
import org.springframework.data.gemfire.function.annotation.OnRegion;
import org.springframework.data.gemfire.function.config.EnableGemfireFunctionExecutions;
import org.springframework.stereotype.Component;

@Component
@OnRegion(region="Factorials")
public interface FunctionExecution {
	@FunctionId("extractFunction")
	Collection<Long> extract(String v1, String v2);
}
