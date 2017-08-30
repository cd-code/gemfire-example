package me.cauley.gemfireserverdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.CacheListener;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.RegionEvent;

@Component
public class CacheListenerImpl implements CacheListener{
	protected static final Logger LOGGER = LoggerFactory.getLogger(CacheListenerImpl.class);
	@Override
	public void close() {
		LOGGER.info("create");
		
	}

	@Override
	public void afterCreate(EntryEvent paramEntryEvent) {
		LOGGER.info("afterCreate");
		
	}

	@Override
	public void afterUpdate(EntryEvent paramEntryEvent) {
		LOGGER.info("afterUpdate");
		
	}

	@Override
	public void afterInvalidate(EntryEvent paramEntryEvent) {
		// TODO Auto-generated method stub
		LOGGER.info("afterInvalidate");
	}

	@Override
	public void afterDestroy(EntryEvent paramEntryEvent) {
		// TODO Auto-generated method stub
		LOGGER.info("afterDestroy");
	}

	@Override
	public void afterRegionInvalidate(RegionEvent paramRegionEvent) {
		// TODO Auto-generated method stub
		LOGGER.info("afterRegionInvalidate");
	}

	@Override
	public void afterRegionDestroy(RegionEvent paramRegionEvent) {
		// TODO Auto-generated method stub
		LOGGER.info("afterRegionDestroy");
	}

	@Override
	public void afterRegionClear(RegionEvent paramRegionEvent) {
		// TODO Auto-generated method stub
		LOGGER.info("afterRegionClear");
	}

	@Override
	public void afterRegionCreate(RegionEvent paramRegionEvent) {
		// TODO Auto-generated method stub
		LOGGER.info("afterRegionCreate");
	}

	@Override
	public void afterRegionLive(RegionEvent paramRegionEvent) {
		// TODO Auto-generated method stub
		LOGGER.info("afterRegionLive");
	}

}
