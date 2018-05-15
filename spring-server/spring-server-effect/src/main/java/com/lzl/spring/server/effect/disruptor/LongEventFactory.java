package com.lzl.spring.server.effect.disruptor;

import java.util.concurrent.Future;

import com.lmax.disruptor.EventFactory;

public class LongEventFactory implements EventFactory<LongEvent> {

	@Override
	public LongEvent newInstance() {
		Future<Integer> bb = null;
		return new LongEvent();
	}

}
