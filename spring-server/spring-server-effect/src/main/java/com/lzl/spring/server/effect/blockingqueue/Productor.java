package com.lzl.spring.server.effect.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

import com.lzl.spring.server.effect.utils.StaticUtils;

public class Productor implements Runnable {

	private LinkedBlockingQueue<String> queue;
	private boolean isStop = false;

	public Productor(LinkedBlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (!isStop) {
			try {
				queue.put(StaticUtils.getThreadName("Productor") + "生产消息");
				StaticUtils.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopRun() {
		this.isStop = true;
	}

}
