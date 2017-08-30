package me.cauley.gemfireclientdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.query.CqEvent;
import com.gemstone.gemfire.cache.query.CqQuery;

@Component
public class DefaultEventDelegate implements EventDelegate{
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultEventDelegate.class);
	@Override
	public void handleEvent(CqEvent event) {
		// TODO Auto-generated method stub
		LOGGER.info("handleEvent1");
	}

	@Override
	public void handleEvent(Operation baseOp) {
		// TODO Auto-generated method stub
		LOGGER.info("handleEvent2");
	}

	@Override
	public void handleEvent(Object key) {
		// TODO Auto-generated method stub
		LOGGER.info("handleEvent3");
	}

	@Override
	public void handleEvent(Object key, Object newValue) {
		// TODO Auto-generated method stub
		LOGGER.info("handleEvent4" + key + ", " + newValue);
	}

	@Override
	public void handleEvent(Throwable th) {
		// TODO Auto-generated method stub
		LOGGER.info("handleEvent5" + th);
	}

	@Override
	public void handleQuery(CqQuery cq) {
		// TODO Auto-generated method stub
		LOGGER.info("handleQuery" + cq.getQueryString());
	}

	@Override
	public void handleEvent(CqEvent event, Operation baseOp, byte[] deltaValue) {
		// TODO Auto-generated method stub
		LOGGER.info("handleEvent6");
	}

	@Override
	public void handleEvent(CqEvent event, Operation baseOp, Operation queryOp, Object key, Object newValue) {
		// TODO Auto-generated method stub
		LOGGER.info("handleEvent7");
	}

}
