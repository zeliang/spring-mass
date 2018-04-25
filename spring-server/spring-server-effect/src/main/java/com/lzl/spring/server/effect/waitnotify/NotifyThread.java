package com.lzl.spring.server.effect.waitnotify;

import com.lzl.spring.server.effect.utils.StaticUtils;

public class NotifyThread extends Thread {

	private volatile Object lock;

	public NotifyThread(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println(StaticUtils.getThreadName("NotifyThread") + "唤醒一个等待队列线程");
			lock.notify();
			StaticUtils.sleepFix(1000);
			System.out.println(StaticUtils.getThreadName("NotifyThread") + "唤醒一个等待队列线程end----");
		}
	}

}
