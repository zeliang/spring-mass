package com.lzl.spring.server.effect.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

import com.lzl.spring.server.effect.utils.StaticUtils;

public class Conusumer implements Runnable {

	private LinkedBlockingQueue<String> queue;
	private boolean isStop = false;

	public Conusumer(LinkedBlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (!isStop) {
			try {
				System.out.println("消费者：" + StaticUtils.getThreadName("")
						+ "开始获取数据");
				String get = queue.take();
				System.out.println(StaticUtils.getThreadName("") + " 获得数据-->"
						+ get);
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
