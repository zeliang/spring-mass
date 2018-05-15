package com.lzl.spring.server.effect.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

import com.lzl.spring.server.effect.utils.StaticUtils;

public class Monitor implements Runnable {

	private LinkedBlockingQueue<String> queue;
	private boolean isStop = false;

	public Monitor(LinkedBlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (!isStop) {
			StaticUtils.sleepFix(1000);
			System.out.println("当前剩余数据大小：" + queue.size());
		}
	}

	public void stopRun() {
		this.isStop = true;
	}

}
